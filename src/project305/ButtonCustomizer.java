
package project305;
import javax.swing.*;
import java.awt.*;

public class ButtonCustomizer {
    public static void customizeButton(JButton button, Dimension size) {
        button.setPreferredSize(size);
        button.setFont(new Font("Arial", Font.PLAIN, 17));
        button.setFocusPainted(false);
        button.setBackground(new Color(207, 229, 200));
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    }
}
