package project305;

import javax.swing.*;
import java.awt.*;

public class HomePage {
    private JFrame homeFrame;

    public HomePage() {
        homeFrame = new JFrame("Home Page");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ضبط الحجم ليكون 900x600 ليكون هناك مساحة كافية للأزرار الكبيرة
        homeFrame.setSize(1000, 600);
        homeFrame.getContentPane().setBackground(new Color(244, 194, 194));
        homeFrame.setLayout(new GridBagLayout());

        // إنشاء الأزرار مع الصور باستخدام المسار الكامل الجديد
        JButton employeeButton = createButtonWithIcon("Employee Management", "emolpyee.png");
        JButton departmentButton = createButtonWithIcon("Department Management", "depatemnt.png");
        JButton reportsButton = createButtonWithIcon("Report Management", "report.png");

        // إعداد الأزرار بحيث تكون أفقية مع مسافات بين الأزرار
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20)); // ترتيب أفقي مع مسافات أكبر بين الأزرار
        buttonPanel.setBackground(new Color(244, 194, 194)); // خلفية مطابقة لخلفية النافذة

        // إضافة الأزرار إلى اللوحة
        buttonPanel.add(employeeButton);
        buttonPanel.add(departmentButton);
        buttonPanel.add(reportsButton);

        // إعداد GridBagConstraints لتوسيط buttonPanel داخل النافذة
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // توسيط اللوحة داخل الإطار
        homeFrame.add(buttonPanel, gbc);

        // ضبط إجراءات الأزرار للانتقال إلى الصفحات الأخرى
        employeeButton.addActionListener(e -> {
            homeFrame.setVisible(false);
            new EmployeeManagement(homeFrame);
        });

        departmentButton.addActionListener(e -> {
            homeFrame.setVisible(false);
            new DepartmentManagement(homeFrame);
        });

        reportsButton.addActionListener(e -> new ReportsPage(homeFrame));

        homeFrame.setLocationRelativeTo(null); // يتمركز في منتصف الشاشة
        homeFrame.setVisible(true);
    }

    // دالة لإنشاء زر مع صورة باستخدام المسار الكامل مع تصغير الصورة وتكبير الزر
    private JButton createButtonWithIcon(String buttonText, String imagePath) {
        // تحميل الصورة وتغيير حجمها
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // تكبير الصورة إلى 150x150
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // إنشاء الزر مع النص والصورة
        JButton button = new JButton(buttonText, scaledIcon);
        button.setHorizontalTextPosition(SwingConstants.CENTER); // جعل النص في المنتصف أسفل الصورة
        button.setVerticalTextPosition(SwingConstants.BOTTOM); // وضع النص أسفل الصورة
        button.setFocusPainted(false); // إزالة التأثير عند التركيز
        button.setBackground(new Color(207, 229, 200)); // لون خلفية الزر
        button.setFont(new Font("Arial", Font.BOLD, 16)); // تكبير خط النص داخل الزر
        button.setPreferredSize(new Dimension(250, 250)); // تكبير حجم الزر ليشمل العرض بشكل أكبر

        return button;
    }

    // نقطة البداية لتشغيل HomePage بشكل مستقل
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage());
    }
}
