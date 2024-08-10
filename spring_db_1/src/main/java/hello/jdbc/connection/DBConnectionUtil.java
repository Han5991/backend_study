package hello.jdbc.connection;

import static hello.jdbc.connection.ConnectionConst.PASSWORD;
import static hello.jdbc.connection.ConnectionConst.URL;
import static hello.jdbc.connection.ConnectionConst.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBConnectionUtil {

  public static Connection getConnection() throws IllegalAccessException {
    try {
      Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
      log.info("Connection: {}", connection);
      return connection;
    } catch (SQLException e) {
      log.error("error: {}", e);
      throw new IllegalAccessException("DB Connection Error");
    }
  }
}
