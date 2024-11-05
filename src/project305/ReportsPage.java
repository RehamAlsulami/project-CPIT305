/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project305;

import javax.swing.*;
import java.awt.*;

public class ReportsPage {
    private JFrame reportsFrame;

    public ReportsPage(JFrame homeFrame) {
        reportsFrame = new JFrame("Reports");
        reportsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportsFrame.setSize(850, 600);
        reportsFrame.getContentPane().setBackground(new Color(244, 194, 194)); // لون الخلفية
        reportsFrame.setLayout(new GridBagLayout());

        JButton dailyButton = new JButton("Daily");
        JButton monthlyButton = new JButton("Monthly");
        JButton yearlyButton = new JButton("Yearly");
        JButton backButton = new JButton("←");

        Dimension buttonSize = new Dimension(250, 70);
        ButtonCustomizer.customizeButton(dailyButton, buttonSize);
        ButtonCustomizer.customizeButton(monthlyButton, buttonSize);
        ButtonCustomizer.customizeButton(yearlyButton, buttonSize);
        ButtonCustomizer.customizeButton(backButton, new Dimension(50, 50));

       
        backButton.addActionListener(e -> {
            reportsFrame.dispose();
            homeFrame.setVisible(true);
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        reportsFrame.add(dailyButton, gbc);

        gbc.gridy = 1;
        reportsFrame.add(monthlyButton, gbc);

        gbc.gridy = 2;
        reportsFrame.add(yearlyButton, gbc);

        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        reportsFrame.add(backButton, gbc);

        reportsFrame.setLocationRelativeTo(null); // يظهر في المنتصف
        reportsFrame.setVisible(true);
    }
}
