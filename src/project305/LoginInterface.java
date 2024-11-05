package project305;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface {

    private JFrame splashFrame;
    private JFrame loginFrame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginInterface(); // Launch the splash screen and login interface
            }
        });
    }

    public LoginInterface() {
        showSplashScreen();
    }

    private void showSplashScreen() {
        // Create a new JFrame (window) for the splash screen
        splashFrame = new JFrame("Splash Screen");
        splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashFrame.setSize(1000, 600); // تعديل حجم النافذة ليطابق الصفحة الرئيسية
        splashFrame.setLayout(null); // Use null layout for absolute positioning
        splashFrame.getContentPane().setBackground(new Color(207, 229, 200)); // Background color

        // Center the frame on the screen
        splashFrame.setLocationRelativeTo(null);

        int centerX = splashFrame.getWidth() / 2; // مركز العرض
        int centerY = splashFrame.getHeight() / 2; // مركز الارتفاع

        // Load the logo image
        ImageIcon logoIcon = new ImageIcon("1-removebg-preview.png");
        JLabel logoLabel = new JLabel(logoIcon);
        int logoWidth = logoIcon.getIconWidth();
        int logoHeight = logoIcon.getIconHeight();

        // Center the logo in the middle of the frame
        logoLabel.setBounds(centerX - (logoWidth / 2), centerY - (logoHeight / 2) - 70, logoWidth, logoHeight);

        splashFrame.add(logoLabel);

        // Create the "Start Now" button
        JButton startButton = new JButton("Start Now");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBackground(new Color(255, 255, 255));
        startButton.setForeground(Color.BLACK);
        startButton.setFocusPainted(false);
        startButton.setBounds(centerX - 75, centerY + 100, 150, 40); // وضع الزر أسفل الشعار
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setContentAreaFilled(false);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);
        startButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        splashFrame.add(startButton);

        // Add action listener to the button to open the login screen
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashFrame.dispose(); // Close splash screen
                showLoginScreen(); // Show login screen
            }
        });

        // Create label with the text "For employee management" and position it in the center
        JLabel employeeLabel = new JLabel("For employee management");
        employeeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        employeeLabel.setForeground(Color.BLACK);
        employeeLabel.setBounds(centerX - 150, centerY + 50, 300, 30); // وضع النص أسفل الشعار مباشرة
        splashFrame.add(employeeLabel);

        // Finalize splash screen settings
        splashFrame.setVisible(true); // Show the splash screen
    }

    private void showLoginScreen() {
        // Create a new JFrame (window) for login interface
        loginFrame = new JFrame("Login Interface");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(1000, 600); // تعديل حجم النافذة ليطابق الصفحة الرئيسية
        loginFrame.setLayout(null); // Use null layout for custom positioning
        loginFrame.getContentPane().setBackground(new Color(244, 194, 194)); // Set background color

        // Center the frame on the screen
        loginFrame.setLocationRelativeTo(null);

        int centerX = loginFrame.getWidth() / 2; // مركز العرض
        int centerY = loginFrame.getHeight() / 2; // مركز الارتفاع

        // Add "Welcome, login to continue" label
        JLabel welcomeLabel = new JLabel("Welcome, login to continue");
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setBounds(centerX - 100, centerY - 150, 300, 30); // تموضع في المركز
        loginFrame.add(welcomeLabel);

        // Create email label and text field
        JLabel emailLabel = new JLabel("User name ");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setBounds(centerX - 125, centerY - 100, 250, 20);
        loginFrame.add(emailLabel);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailTextField.setBounds(centerX - 125, centerY - 70, 250, 40);
        emailTextField.setBorder(BorderFactory.createLineBorder(new Color(100, 180, 100), 2));
        loginFrame.add(emailTextField);

        // Create password label and text field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(centerX - 125, centerY - 20, 250, 20);
        loginFrame.add(passwordLabel);

        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordTextField.setBounds(centerX - 125, centerY + 10, 250, 40);
        passwordTextField.setBorder(BorderFactory.createLineBorder(new Color(100, 180, 100), 2));
        loginFrame.add(passwordTextField);

        // Create Login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(new Color(150, 200, 150));
        loginButton.setFocusPainted(false);
        loginButton.setBounds(centerX - 125, centerY + 70, 250, 50); // Button spans across under the password field
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(150, 200, 150), 2, true));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginFrame.add(loginButton);

        // Set up event listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = emailTextField.getText();
                String password = new String(passwordTextField.getPassword());

                // Validate credentials without database
                if ("project".equals(username) && "1234".equals(password)) {
                    JOptionPane.showMessageDialog(loginFrame, "Login Successful");

                    // Hide the login frame and open the home page (Employee Management)
                    loginFrame.setVisible(false);
                    new HomePage(); // Open the home page
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid username or password");
                }
            }
        });

        // Make the login frame visible
        loginFrame.setVisible(true);
    }
}
