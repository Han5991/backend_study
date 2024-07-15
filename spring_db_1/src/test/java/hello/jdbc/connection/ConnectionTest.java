package hello.jdbc.connection;

import static hello.jdbc.connection.ConnectionConst.PASSWORD;
import static hello.jdbc.connection.ConnectionConst.URL;
import static hello.jdbc.connection.ConnectionConst.USER;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Slf4j
public class ConnectionTest {

  @Test
  void driverManager() throws SQLException {
    Connection con1 = DriverManager.getConnection(URL, USER, PASSWORD);
    Connection con2 = DriverManager.getConnection(URL, USER, PASSWORD);
    log.info("con1: {}", con1);
    log.info("con2: {}", con2);
  }

  @Test
  void dataSourceDriverManager() throws SQLException {
    DataSource con1 = new DriverManagerDataSource(URL, USER, PASSWORD);
    log.info("con1: {}", con1);
  }

  @Test
  void dataSourceConnectionPool() throws SQLException, InterruptedException {
    // 커넥션 풀링
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(URL);
    dataSource.setUsername(USER);
    dataSource.setPassword(PASSWORD);
    dataSource.setMaximumPoolSize(10);
    dataSource.setPoolName("MyPoll");

    useDataSource(dataSource);
    Thread.sleep(1000);

  }

  private void useDataSource(DataSource dataSource) throws SQLException {
    Connection connection = dataSource.getConnection();
    log.info("connection: {}, class: {}", connection, connection.getClass());
  }
}
