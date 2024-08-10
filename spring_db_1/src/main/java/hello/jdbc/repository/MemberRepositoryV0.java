package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lombok.extern.slf4j.Slf4j;

/**
 * JDBC - DriverManager를 이용한 Connection 획득
 */
@Slf4j
public class MemberRepositoryV0 {

  private Connection getConnection() throws IllegalAccessException {
    return DBConnectionUtil.getConnection();
  }

  private void close(Connection connection, PreparedStatement preparedStatement) {
    try {
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (Exception e) {
      log.error("error: {}", e);
    }
  }


  public Member save(Member member) {
    log.info("Member save: {}", member);
    String sql = "insert into member(member_id, money) values(?, ?)";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, member.getMemberId());
      preparedStatement.setInt(2, member.getMoney());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      log.error("error: {}", e);
    } finally {
      close(connection, preparedStatement);
    }
    return member;
  }

  public Member findById(String memberId) {
    log.info("Member findById: {}", memberId);
    String sql = "select * from member where member_id = ?";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, memberId);
      resultSet = preparedStatement.executeQuery();
      return resultSet.next() ? new Member(resultSet.getString("member_id"),
          resultSet.getInt("money")) : null;
    } catch (Exception e) {
      log.error("error: {}", e);
    } finally {
      close(connection, preparedStatement);
    }
    return null;
  }
}
