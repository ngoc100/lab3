package lab3.bai2;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/employee_db?serverTimezone=UTC";
        String dbUser = "root";
        String dbPass = "123456";

        EmployeeDAO dao = new EmployeeDAO(jdbcUrl, dbUser, dbPass);
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Danh sách nhân viên");
            System.out.println("3. Xem chi tiết nhân viên");
            System.out.println("4. Cập nhật nhân viên");
            System.out.println("5. Xóa nhân viên");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            String choice = sc.nextLine().trim();

            try {

                switch (choice) {

                    case "1":

                        Employee e = new Employee();

                        System.out.print("Mã NV: ");
                        e.setEmpCode(sc.nextLine().trim());

                        System.out.print("Họ tên: ");
                        e.setFullName(sc.nextLine().trim());

                        System.out.print("Email: ");
                        e.setEmail(sc.nextLine().trim());

                        System.out.print("Phone: ");
                        e.setPhone(sc.nextLine().trim());

                        System.out.print("Gender (Male/Female/Other): ");
                        e.setGender(sc.nextLine().trim());

                        System.out.print("Ngày sinh (yyyy-MM-dd): ");
                        e.setBirthDate(LocalDate.parse(sc.nextLine().trim()));

                        System.out.print("Phòng ban: ");
                        e.setDepartment(sc.nextLine().trim());

                        System.out.print("Chức vụ: ");
                        e.setPosition(sc.nextLine().trim());

                        System.out.print("Lương: ");
                        e.setSalary(new BigDecimal(sc.nextLine().trim()));

                        if (dao.insert(e)) {
                            System.out.println("Thêm nhân viên thành công!");
                        } else {
                            System.out.println("Thêm nhân viên thất bại!");
                        }

                        break;

                    case "2":

                        System.out.print("Từ khóa tìm kiếm (Enter = tất cả): ");
                        String keyword = sc.nextLine().trim();

                        dao.list(keyword);

                        break;

                    case "3":

                        System.out.print("Nhập mã nhân viên: ");
                        String code = sc.nextLine().trim();

                        Employee emp = dao.findByCode(code);

                        if (emp == null) {

                            System.out.println("Không tìm thấy nhân viên.");

                        } else {

                            System.out.println("\n===== THÔNG TIN NHÂN VIÊN =====");
                            System.out.println("Mã NV: " + emp.getEmpCode());
                            System.out.println("Họ tên: " + emp.getFullName());
                            System.out.println("Email: " + emp.getEmail());
                            System.out.println("Phone: " + emp.getPhone());
                            System.out.println("Giới tính: " + emp.getGender());
                            System.out.println("Ngày sinh: " + emp.getBirthDate());
                            System.out.println("Phòng ban: " + emp.getDepartment());
                            System.out.println("Chức vụ: " + emp.getPosition());
                            System.out.println("Lương: " + emp.getSalary());
                        }

                        break;

                    case "4":

                        System.out.print("Nhập mã NV cần cập nhật: ");
                        String updateCode = sc.nextLine().trim();

                        Employee updateEmp = dao.findByCode(updateCode);

                        if (updateEmp == null) {
                            System.out.println("Không tìm thấy nhân viên.");
                            break;
                        }

                        System.out.print("Họ tên mới: ");
                        updateEmp.setFullName(sc.nextLine().trim());

                        System.out.print("Email mới: ");
                        updateEmp.setEmail(sc.nextLine().trim());

                        System.out.print("Phone mới: ");
                        updateEmp.setPhone(sc.nextLine().trim());

                        System.out.print("Gender mới: ");
                        updateEmp.setGender(sc.nextLine().trim());

                        System.out.print("Ngày sinh mới (yyyy-MM-dd): ");
                        updateEmp.setBirthDate(LocalDate.parse(sc.nextLine().trim()));

                        System.out.print("Phòng ban mới: ");
                        updateEmp.setDepartment(sc.nextLine().trim());

                        System.out.print("Chức vụ mới: ");
                        updateEmp.setPosition(sc.nextLine().trim());

                        System.out.print("Lương mới: ");
                        updateEmp.setSalary(new BigDecimal(sc.nextLine().trim()));

                        if (dao.update(updateEmp)) {
                            System.out.println("Cập nhật thành công!");
                        } else {
                            System.out.println("Cập nhật thất bại!");
                        }

                        break;

                    case "5":

                        System.out.print("Nhập mã NV cần xóa: ");
                        String deleteCode = sc.nextLine().trim();

                        if (dao.delete(deleteCode)) {
                            System.out.println("Xóa thành công!");
                        } else {
                            System.out.println("Không tìm thấy nhân viên.");
                        }

                        break;

                    case "6":

                        System.out.println("Tạm biệt!");
                        sc.close();
                        return;

                    default:

                        System.out.println("Lựa chọn không hợp lệ.");
                }

            } catch (Exception ex) {

                System.out.println("Lỗi: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}