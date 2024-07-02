import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePlainJdbcExample {
  static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
  static final String USER = "root";
  static final String PASS = "1234";
  static final String QUERY = "UPDATE students SET name = ?, age = ? WHERE id = ?";

  public static void main(String[] args) {
    int updatedId = 2;
    String updatedName = "한빛2";
    int updatedAge = 35;

    // Open & get a connection
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = conn.prepareStatement(QUERY)) {
      pstmt.setString(1, updatedName);
      pstmt.setInt(2, updatedAge);
      pstmt.setInt(3, updatedId);

      int rowsAffected = pstmt.executeUpdate();
      System.out.println(rowsAffected + " row(s) updated.");

    } catch (SQLException e) {
      System.out.println(e.getErrorCode());
      System.out.println(e.getMessage());
    }
  }
}
