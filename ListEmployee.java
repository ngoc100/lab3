package lab3.bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
    private String dbUser = "root";
    private String dbPass = "123456";

    public void list(String search) throws SQLException {

        String sql = "SELECT emp_code, full_name, email, department, position, salary "
                   + "FROM employees";

        boolean useSearch = search != null && !search.isBlank();

        if (useSearch) {
            sql += " WHERE emp_code LIKE ? OR full_name LIKE ?";
        }

        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (useSearch) {
                String q = "%" + search + "%";
                ps.setString(1, q);
                ps.setString(2, q);
            }

            try (ResultSet rs = ps.executeQuery()) {

                System.out.printf(
                    "%-10s %-25s %-30s %-15s %-20s %-12s%n",
                    "Code", "Full Name", "Email", "Dept", "Position", "Salary"
                );

                while (rs.next()) {
                    System.out.printf(
                        "%-10s %-25s %-30s %-15s %-20s %-12.2f%n",
                        rs.getString("emp_code"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getString("position"),
                        rs.getDouble("salary")
                    );
                }
            }
        }
    }
}