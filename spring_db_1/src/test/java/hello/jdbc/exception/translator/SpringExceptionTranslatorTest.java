package hello.jdbc.exception.translator;

import static hello.jdbc.connection.ConnectionConst.PASSWORD;
import static hello.jdbc.connection.ConnectionConst.URL;
import static hello.jdbc.connection.ConnectionConst.USER;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

@Slf4j
public class SpringExceptionTranslatorTest {

  DataSource dataSource;

  @BeforeEach
  void init() {
    dataSource = new DriverManagerDataSource(URL, USER, PASSWORD);
  }

  @Test
  void sqlExceptionErrorCode() {
    String sql = "select * from memberqqq";

    try {
      Connection connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.executeQuery();
    } catch (SQLException e) {
      assertThat(e.getErrorCode()).isEqualTo(42102);
      int errorCode = e.getErrorCode();
      log.error("errorCode={}", errorCode);
    }
  }

  @Test
  void exceptionTranslator() {
    String sql = "select * from memberqqq";

    try {
      Connection connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.executeQuery();
    } catch (SQLException e) {
      assertThat(e.getErrorCode()).isEqualTo(42102);
      SQLErrorCodeSQLExceptionTranslator exTranslator = new SQLErrorCodeSQLExceptionTranslator(
          dataSource);
      DataAccessException reactEx = exTranslator.translate("select", sql, e);
      log.error("reactEx={}", reactEx.getMessage(), reactEx);
      assertThat(reactEx).isInstanceOf(BadSqlGrammarException.class);
    }

  }

}
