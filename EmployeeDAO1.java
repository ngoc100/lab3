package lab3.bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO1 {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
    private String dbUser = "root";
    private String dbPass = "123456";

    public boolean insert(Employee e) throws SQLException {

        String sql = "INSERT INTO employees "
                + "(emp_code, full_name, email, phone, gender, birth_date, department, position, salary) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getEmpCode());
            ps.setString(2, e.getFullName());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPhone());
            ps.setString(5, e.getGender());
            ps.setDate(6, java.sql.Date.valueOf(e.getBirthDate()));
            ps.setString(7, e.getDepartment());
            ps.setString(8, e.getPosition());
            ps.setBigDecimal(9, e.getSalary());

            return ps.executeUpdate() == 1;
        }
    }
}