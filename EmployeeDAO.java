package lab3.bai2;

public class EmployeeDAO {

    public boolean delete(String code) throws SQLException {

        String sql = "DELETE FROM employees WHERE emp_code = ?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, code);

            return ps.executeUpdate() == 1;
        }
    }
}