/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chkRememberMe;

    // HashMap to store usernames and passwords
    private HashMap<String, String> userCredentials;

    public LoginPage() {
        // Initialize the user credentials HashMap
        userCredentials = new HashMap<>();
        // Example users
        userCredentials.put("admin", "password123");
        userCredentials.put("user1", "mypassword");
        userCredentials.put("guest", "guest123");

        setTitle("Login - Travel Management System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window

        // Setting up the font and colors
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        Color bgColor = new Color(230, 230, 250);  // Lavender background color

        // Set background color
        getContentPane().setBackground(bgColor);

        // Components
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(labelFont);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(labelFont);

        txtUsername = new JTextField();
        txtUsername.setFont(textFont);

        txtPassword = new JPasswordField();
        txtPassword.setFont(textFont);

        chkRememberMe = new JCheckBox("Remember Me");
        chkRememberMe.setFont(textFont);
        chkRememberMe.setBackground(bgColor);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(100, 149, 237));  // Cornflower blue
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(buttonFont);

        JButton btnForgotPassword = new JButton("Forgot Password?");
        btnForgotPassword.setFont(new Font("Arial", Font.ITALIC, 12));
        btnForgotPassword.setBackground(bgColor);
        btnForgotPassword.setForeground(new Color(100, 149, 237));
        btnForgotPassword.setBorderPainted(false);
        btnForgotPassword.setFocusPainted(false);

        // Action listeners
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (validateLogin(username, password)) {
                    new MainDashboard().setVisible(true);  // Show main dashboard
                    dispose();  // Close login page
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnForgotPassword.addActionListener(e -> JOptionPane.showMessageDialog(this, "Password recovery is not implemented in this version."));

        // Layout setup using GridBagLayout for alignment and spacing
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblUsername, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(chkRememberMe, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(btnLogin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(btnForgotPassword, gbc);
    }

    private boolean validateLogin(String username, String password) {
        // Validate login using the HashMap
        if (userCredentials.containsKey(username)) {
            return userCredentials.get(username).equals(password);
        }
        return false;
    }

    public static void main(String[] args) {
        // Start the login page
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
