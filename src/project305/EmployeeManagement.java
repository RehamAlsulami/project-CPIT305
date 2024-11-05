/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project305;
import javax.swing.*;
import java.awt.*;

public class EmployeeManagement {
    private JFrame employeeFrame;

    public EmployeeManagement(JFrame homeFrame) {
        employeeFrame = new JFrame("Employee Management");
        employeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        employeeFrame.setSize(850, 600);
        employeeFrame.getContentPane().setBackground(new Color(244, 194, 194));
        employeeFrame.setLayout(new GridBagLayout());

        JButton employeeInfoButton = new JButton("Employee Information");
        JButton addEmployeeButton = new JButton("Add Employee");
        JButton deleteEmployeeButton = new JButton("Delete Employee");
        JButton backButton = new JButton("←");

        Dimension buttonSize = new Dimension(250, 70);
        ButtonCustomizer.customizeButton(employeeInfoButton, buttonSize);
        ButtonCustomizer.customizeButton(addEmployeeButton, buttonSize);
        ButtonCustomizer.customizeButton(deleteEmployeeButton, buttonSize);
        ButtonCustomizer.customizeButton(backButton, new Dimension(50, 50));

        backButton.addActionListener(e -> {
            employeeFrame.dispose();
            homeFrame.setVisible(true);
        });

        addEmployeeButton.addActionListener(e -> openAddEmployeeForm());
        deleteEmployeeButton.addActionListener(e -> openDeleteEmployeeForm());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        employeeFrame.add(employeeInfoButton, gbc);
        gbc.gridy = 1;
        employeeFrame.add(addEmployeeButton, gbc);
        gbc.gridy = 2;
        employeeFrame.add(deleteEmployeeButton, gbc);
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        employeeFrame.add(backButton, gbc);

        employeeFrame.setLocationRelativeTo(null);
        employeeFrame.setVisible(true);
    }

    // نافذة إضافة موظف
    private void openAddEmployeeForm() {
    JFrame frame = new JFrame("Add New Employee");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 500);
        frame.getContentPane().setBackground(new Color(244, 194, 194));
        frame.setLayout(new GridBagLayout());

        JLabel firstNameLabel = new JLabel("First Name");
        JTextField firstNameField = new JTextField(20);
        JLabel middleNameLabel = new JLabel("Middle Name");
        JTextField middleNameField = new JTextField(20);
        JLabel lastNameLabel = new JLabel("Last Name");
        JTextField lastNameField = new JTextField(20);
        JLabel employeeIDLabel = new JLabel("Employee ID");
        JTextField employeeIDField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(20);
        JLabel employeeTypeLabel = new JLabel("Employee Type");
        String[] employeeTypes = {"Full-Time", "Part-Time", "Contract"};
        JComboBox<String> employeeTypeDropdown = new JComboBox<>(employeeTypes);
        JLabel departmentLabel = new JLabel("Department");
        String[] departments = {"HR", "Finance", "Engineering", "Marketing"};
        JComboBox<String> departmentDropdown = new JComboBox<>(departments);
        JLabel positionLabel = new JLabel("Position");
        JTextField positionField = new JTextField(20);
        JLabel dateOfHireLabel = new JLabel("Date of Hire");
        JTextField dateOfHireField = new JTextField(20);

        JButton backButton = new JButton("←");
        backButton.addActionListener(e -> frame.dispose());

        JButton createButton = new JButton("Create Employee");
        createButton.addActionListener(e -> {
            // تحقق من تعبئة الحقول
            if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || emailField.getText().isEmpty()
                    || employeeTypeDropdown.getSelectedItem() == null || departmentDropdown.getSelectedItem() == null
                    || dateOfHireField.getText().isEmpty() || positionField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // جلب البيانات من الحقول
                String firstName = firstNameField.getText();
                String middleName = middleNameField.getText();
                String lastName = lastNameField.getText();
                String employeeID = employeeIDField.getText();
                String email = emailField.getText();
                String employeeType = employeeTypeDropdown.getSelectedItem().toString();
                String department = departmentDropdown.getSelectedItem().toString();
                String position = positionField.getText();
                String dateOfHire = dateOfHireField.getText();

                // استدعاء دالة الإضافة من DatabaseManager
                DatabaseManager dbManager = new DatabaseManager();
                dbManager.addEmployee(firstName, middleName, lastName, employeeID, email, employeeType, department, position, dateOfHire);

                JOptionPane.showMessageDialog(frame, "Employee created successfully!");
                
                // تفريغ الحقول بعد إضافة الموظف
                firstNameField.setText("");
                middleNameField.setText("");
                lastNameField.setText("");
                employeeIDField.setText("");
                emailField.setText("");
                employeeTypeDropdown.setSelectedIndex(0);
                departmentDropdown.setSelectedIndex(0);
                positionField.setText("");
                dateOfHireField.setText("");
            }
        });

        // إعدادات تخطيط الواجهة
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        frame.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        frame.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(middleNameLabel, gbc);
        gbc.gridx = 1;
        frame.add(middleNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        frame.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(employeeIDLabel, gbc);
        gbc.gridx = 1;
        frame.add(employeeIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(emailLabel, gbc);
        gbc.gridx = 1;
        frame.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(employeeTypeLabel, gbc);
        gbc.gridx = 1;
        frame.add(employeeTypeDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(departmentLabel, gbc);
        gbc.gridx = 1;
        frame.add(departmentDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        frame.add(positionLabel, gbc);
        gbc.gridx = 1;
        frame.add(positionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        frame.add(dateOfHireLabel, gbc);
        gbc.gridx = 1;
        frame.add(dateOfHireField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        frame.add(backButton, gbc);
        gbc.gridx = 1;
        frame.add(createButton, gbc);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // نافذة حذف موظف
    private void openDeleteEmployeeForm() {
        JFrame frame = new JFrame("Delete Employee");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().setBackground(new Color(244, 194, 194));
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Delete Employee by ID:");
        JTextField idField = new JTextField(10);
        JButton deleteButton = new JButton("Delete");

        deleteButton.addActionListener(e -> {
            String id = idField.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter an Employee ID.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Employee with ID " + id + " deleted successfully!");
                frame.dispose();
            }
        });

        frame.add(label);
        frame.add(idField);
        frame.add(deleteButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
