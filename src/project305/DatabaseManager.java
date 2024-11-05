package project305;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/EmployeeManagement";
    private static final String USER = "root";
    private static final String PASSWORD = "112233";
    private Connection connection;

    public DatabaseManager() {
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to database: EmployeeManagement");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public void addEmployee(String firstName, String middleName, String lastName, String employeeID, String email, 
                            String employeeType, String department, String position, String dateOfHire) {
        String query = "INSERT INTO employees (first_name, middle_name, last_name, employee_id, email, employee_type, department, position, date_of_hire) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, middleName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, employeeID);
            pstmt.setString(5, email);
            pstmt.setString(6, employeeType);
            pstmt.setString(7, department);
            pstmt.setString(8, position);
            pstmt.setString(9, dateOfHire);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("تم إضافة الموظف بنجاح!");
            }
        } catch (SQLException e) {
            System.out.println("حدث خطأ أثناء إضافة الموظف: " + e.getMessage());
            e.printStackTrace();
        }
    }
}