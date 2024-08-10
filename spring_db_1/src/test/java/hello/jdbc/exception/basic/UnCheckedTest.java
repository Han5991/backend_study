package hello.jdbc.exception.basic;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class UnCheckedTest {

  @Test
  void unchecked_catch() {
    Repository repository = new Repository();
    Service service = new Service(repository);
    service.callCatch();
  }

  @Test
  void unchecked_throw() {
    Repository repository = new Repository();
    Service service = new Service(repository);
    assertThatThrownBy(service::callThrow)
        .isInstanceOf(RuntimeException.class);
  }

  /**
   * RuntimeException을 상속 받은 예외는 언체크 예외가 된다.
   */
  static class MyUnCheckedException extends RuntimeException {

    public MyUnCheckedException(String message) {
      super(message);
    }
  }

  static class Service {

    private final Repository repository;

    public Service(Repository repository) {
      this.repository = repository;
    }

    public void callCatch() {
      try {
        repository.call();
      } catch (MyUnCheckedException e) {
        log.info("error, message={}", e.getMessage(), e);
      }
    }

    public void callThrow() {
      repository.call();
    }
  }

  static class Repository {

    public void call() {
      throw new MyUnCheckedException("Unchecked Exception");
    }
  }

}
