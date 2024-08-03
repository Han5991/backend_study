package hello.jdbc.exception.basic;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.ConnectException;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

public class CheckedAppTest {

  @Test
  public void checked() {
    Controller controller = new Controller();
    assertThrows(Exception.class, controller::request);
  }

  static class Controller {

    Service service = new Service();

    public void request() throws ConnectException, SQLException {
      service.login();
    }
  }

  static class Service {

    NetworkClient networkClient = new NetworkClient();
    Repository repository = new Repository();

    public void login() throws ConnectException, SQLException {
      networkClient.call();
      repository.call();
    }

  }

  static class NetworkClient {

    public void call() throws ConnectException {
      throw new ConnectException("ex");
    }

  }

  static class Repository {

    public void call() throws SQLException {
      throw new SQLException("ex");
    }
  }

}
