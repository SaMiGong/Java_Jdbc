import java.sql.*;

public class PlainJdbcExmple {
  static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
  static final String USER = "root";
  static final String PASS = "1234";
  static final String QUERY = "SELECT * FROM students";

  public static void main(String[] args) {
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY)) {

      while (rs.next()) {
        System.out.print("ID: " + rs.getInt("id"));
        System.out.print(", name: " + rs.getString("name"));
        System.out.print(", Age: " + rs.getInt("age"));
        System.out.println(", address: " + rs.getString("address"));
      }
    } catch (SQLException e) {
      System.out.println(e.getErrorCode());
      System.out.println(e.getMessage());
    }
  }
}
