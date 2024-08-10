package hello.jdbc.exception.basic;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class CheckedTest {

  @Test
  void checked_catch() {
    Repository repository = new Repository();
    Service service = new Service(repository);
    service.callCatch();
  }

  @Test
  void checked_throw() {
    Repository repository = new Repository();
    Service service = new Service(repository);

    assertThatThrownBy(service::callThrow)
        .isInstanceOf(MyCheckedException.class);
  }

  /**
   * Exception을 상속 받은 예외는 체크 예외가 된다.
   */
  static class MyCheckedException extends Exception {

    public MyCheckedException(String message) {
      super(message);
    }
  }

  /**
   * 예외를 잡아서 처리하는 코드
   */
  static class Service {

    private final Repository repository;

    public Service(Repository repository) {
      this.repository = repository;
    }

    /**
     * 예외를 잡아서 처리하는 코드
     */
    public void callCatch() {
      try {
        repository.call();
      } catch (MyCheckedException e) {
        log.error("error, message={}", e.getMessage(), e);
      }
    }

    /**
     * 예외를 던지는 코드
     */
    public void callThrow() throws MyCheckedException {
      repository.call();
    }
  }

  static class Repository {

    public void call() throws MyCheckedException {
      throw new MyCheckedException("ex");
    }
  }

}
