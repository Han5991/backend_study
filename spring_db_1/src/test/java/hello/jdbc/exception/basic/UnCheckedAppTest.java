package hello.jdbc.exception.basic;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class UnCheckedAppTest {

  @Test
  public void unchecked() {
    Controller controller = new Controller();
    assertThrows(RuntimeException.class, controller::request);
  }

  @Test
  void printException() {
    Controller controller = new Controller();
    try {
      controller.request();
    } catch (Exception e) {
      log.error("ex", e);
    }
  }

  static class Controller {

    Service service = new Service();

    public void request() {
      service.login();
    }
  }

  static class Service {

    NetworkClient networkClient = new NetworkClient();
    Repository repository = new Repository();

    public void login() {
      repository.call();
      networkClient.call();
    }

  }

  static class NetworkClient {

    public void call() {
      throw new RuntimeConnectException("연결 실패");
    }

  }

  static class Repository {

    public void call() {
      try {
        runSQL();
      } catch (SQLException e) {
        throw new RuntimeSQLException(e);
      }
    }

    public void runSQL() throws SQLException {
      throw new SQLException("ex");
    }
  }

  static class RuntimeConnectException extends RuntimeException {

    public RuntimeConnectException(String message) {
      super(message);
    }
  }

  static class RuntimeSQLException extends RuntimeException {

    public RuntimeSQLException(Throwable cause) {
      super(cause);
    }
  }
}
