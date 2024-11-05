package project305;

import javax.swing.*;
import java.awt.*;

public class DepartmentManagement {
    private JFrame departmentFrame;

    public DepartmentManagement(JFrame homeFrame) {
        departmentFrame = new JFrame("Department Management");
        departmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        departmentFrame.setSize(850, 600);
        departmentFrame.getContentPane().setBackground(new Color(244, 194, 194));
        departmentFrame.setLayout(new GridBagLayout());

        JButton addDepartmentButton = new JButton("Add Department");
        JButton modifyDepartmentButton = new JButton("Modify Department");
        JButton deleteDepartmentButton = new JButton("Delete Department");
        JButton backButton = new JButton("←");

        Dimension buttonSize = new Dimension(250, 70);
        ButtonCustomizer.customizeButton(addDepartmentButton, buttonSize);
        ButtonCustomizer.customizeButton(modifyDepartmentButton, buttonSize);
        ButtonCustomizer.customizeButton(deleteDepartmentButton, buttonSize);
        ButtonCustomizer.customizeButton(backButton, new Dimension(50, 50));

        backButton.addActionListener(e -> {
            departmentFrame.dispose();
            homeFrame.setVisible(true);
        });

        addDepartmentButton.addActionListener(e -> openAddDepartmentForm());
        modifyDepartmentButton.addActionListener(e -> openModifyDepartmentForm());
        deleteDepartmentButton.addActionListener(e -> openDeleteDepartmentForm());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        departmentFrame.add(addDepartmentButton, gbc);

        gbc.gridy = 1;
        departmentFrame.add(modifyDepartmentButton, gbc);

        gbc.gridy = 2;
        departmentFrame.add(deleteDepartmentButton, gbc);

        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        departmentFrame.add(backButton, gbc);

        departmentFrame.setLocationRelativeTo(null);
        departmentFrame.setVisible(true);
    }

    // نافذة إضافة قسم جديد
    private void openAddDepartmentForm() {
        JFrame frame = new JFrame("Add New Department");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.getContentPane().setBackground(new Color(244, 194, 194));
        frame.setLayout(new GridBagLayout());

        JLabel nameLabel = new JLabel("Department Name:");
        JTextField nameField = new JTextField(20);

        JLabel depIdLabel = new JLabel("Department ID:");
        JTextField depIdField = new JTextField(20);

        JLabel employeesLabel = new JLabel("Number of Employees:");
        JTextField employeesField = new JTextField(20);

        JLabel managerLabel = new JLabel("Manager Name:");
        JTextField managerField = new JTextField(20);

        JLabel budgetLabel = new JLabel("Budget:");
        JTextField budgetField = new JTextField(20);

        JButton addButton = new JButton("Add Department");
        addButton.addActionListener(e -> {
            if (nameField.getText().isEmpty() || depIdField.getText().isEmpty() ||
                    employeesField.getText().isEmpty() || managerField.getText().isEmpty() || budgetField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Department added successfully!");
                frame.dispose();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(nameLabel, gbc);
        gbc.gridx = 1;
        frame.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(depIdLabel, gbc);
        gbc.gridx = 1;
        frame.add(depIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(employeesLabel, gbc);
        gbc.gridx = 1;
        frame.add(employeesField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(managerLabel, gbc);
        gbc.gridx = 1;
        frame.add(managerField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(budgetLabel, gbc);
        gbc.gridx = 1;
        frame.add(budgetField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(addButton, gbc);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // نافذة تعديل القسم
    private void openModifyDepartmentForm() {
        JFrame frame = new JFrame("Modify Department");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        String[] columnNames = {"Department Name", "Department ID", "Number of Employees", "Manager", "Budget"};
        String[][] departments = {
            {"HR", "001", "5", "Alice Johnson", "$100,000"},
            {"IT", "002", "10", "Bob Smith", "$200,000"}
        };

        JTable table = new JTable(departments, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Department ID:"));
        JTextField depIdField = new JTextField(10);
        panel.add(depIdField);

        panel.add(new JLabel("New Department Name:"));
        JTextField nameField = new JTextField(10);
        panel.add(nameField);

        panel.add(new JLabel("Number of Employees:"));
        JTextField employeesField = new JTextField(10);
        panel.add(employeesField);

        panel.add(new JLabel("New Manager:"));
        JTextField managerField = new JTextField(10);
        panel.add(managerField);

        panel.add(new JLabel("New Budget:"));
        JTextField budgetField = new JTextField(10);
        panel.add(budgetField);

        JButton modifyButton = new JButton("Modify");
        panel.add(modifyButton);

        frame.add(panel, BorderLayout.SOUTH);

        modifyButton.addActionListener(e -> {
            String depId = depIdField.getText();
            boolean found = false;

            for (int i = 0; i < departments.length; i++) {
                if (departments[i][1].equals(depId)) {
                    if (nameField.getText().isEmpty() || employeesField.getText().isEmpty() ||
                            managerField.getText().isEmpty() || budgetField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    departments[i][0] = nameField.getText();
                    departments[i][2] = employeesField.getText();
                    departments[i][3] = managerField.getText();
                    departments[i][4] = budgetField.getText();
                    table.repaint();
                    JOptionPane.showMessageDialog(frame, "Department modified successfully!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(frame, "Department ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // نافذة حذف القسم
    private void openDeleteDepartmentForm() {
        JFrame frame = new JFrame("Delete Department");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new GridBagLayout());

        JLabel idLabel = new JLabel("Department ID:");
        JTextField idField = new JTextField(10);
        JLabel nameLabel = new JLabel("Department Name:");
        JTextField nameField = new JTextField(10);
        JButton deleteButton = new JButton("Delete");

        deleteButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            if (id.isEmpty() || name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter both Department ID and Name.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Department '" + name + "' deleted successfully!");
                frame.dispose();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(idLabel, gbc);
        gbc.gridx = 1;
        frame.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(nameLabel, gbc);
        gbc.gridx = 1;
        frame.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(deleteButton, gbc);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
