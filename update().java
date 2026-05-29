package lab3.bai2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/employee_db";
    private String dbUser = "root";
    private String dbPass = "";

    public boolean update(Employee e) throws SQLException {

        String sql = "UPDATE employees "
                   + "SET full_name = ?, "
                   + "email = ?, "
                   + "phone = ?, "
                   + "gender = ?, "
                   + "birth_date = ?, "
                   + "department = ?, "
                   + "position = ?, "
                   + "salary = ? "
                   + "WHERE emp_code = ?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getFullName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getPhone());
            ps.setString(4, e.getGender());
            ps.setDate(5, Date.valueOf(e.getBirthDate()));
            ps.setString(6, e.getDepartment());
            ps.setString(7, e.getPosition());
            ps.setBigDecimal(8, e.getSalary());
            ps.setString(9, e.getEmpCode());

            return ps.executeUpdate() == 1;
        }
    }
}