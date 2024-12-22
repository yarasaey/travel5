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
///////////////////////////// login page with hashmap//////////
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
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window

        // Setting up the font and colors
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font textFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
        Color bgColor = new Color(230, 230, 250);  // Lavender background color
        Color buttonColor = new Color(100, 149, 237);  // Cornflower blue for buttons
        Color hoverColor = new Color(70, 130, 180);  // Darker blue for hover effect

        // Set background color
        getContentPane().setBackground(bgColor);

        // Components
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(labelFont);
        lblUsername.setForeground(Color.DARK_GRAY);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(labelFont);
        lblPassword.setForeground(Color.DARK_GRAY);

        txtUsername = new JTextField();
        txtUsername.setFont(textFont);
        txtUsername.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        txtUsername.setPreferredSize(new Dimension(250, 30));

        txtPassword = new JPasswordField();
        txtPassword.setFont(textFont);
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        txtPassword.setPreferredSize(new Dimension(250, 30));

        chkRememberMe = new JCheckBox("Remember Me");
        chkRememberMe.setFont(textFont);
        chkRememberMe.setBackground(bgColor);
        chkRememberMe.setForeground(Color.DARK_GRAY);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(buttonColor);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(buttonFont);
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new Dimension(250, 40));
        btnLogin.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        JButton btnForgotPassword = new JButton("Forgot Password?");
        btnForgotPassword.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        btnForgotPassword.setBackground(bgColor);
        btnForgotPassword.setForeground(buttonColor);
        btnForgotPassword.setBorderPainted(false);
        btnForgotPassword.setFocusPainted(false);

        // Hover effect for buttons
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(buttonColor);
            }
        });

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
        gbc.insets = new Insets(15, 15, 15, 15);  // Padding around components
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
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
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
