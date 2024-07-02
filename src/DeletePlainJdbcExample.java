import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePlainJdbcExample {
  static final String DB_URL = "jdbc:mysql//localhost:3306/test_db";
  static final String USER = "root";
  static final String PASS = "1234";
  static final String QUERY = "DELETE FROM students WHERE id = ?";

  public static void main(String[] args) {
    int deletedId = 1;
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = conn.prepareStatement(QUERY)) {

      pstmt.setInt(1, deletedId);
      int rowsAffected = pstmt.executeUpdate();
      System.out.println(rowsAffected + " row(s) deleted.");
    } catch (SQLException e) {
      System.out.println(e.getErrorCode());
      System.out.println(e.getMessage());
    }
  }
}
