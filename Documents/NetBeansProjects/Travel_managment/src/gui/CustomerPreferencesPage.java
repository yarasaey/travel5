/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

///////////////////CustomerPreferencesPage gui///////////////////
public class CustomerPreferencesPage extends JFrame {

    // Declare the HashMap to store customer preferences
    private HashMap<String, ArrayList<String>> customerPreferences;

    public CustomerPreferencesPage(HashMap<String, ArrayList<String>> customerPreferences) {
        // Initialize the HashMap passed from the main class
        this.customerPreferences = customerPreferences;

        setTitle("Customer Preferences");
        setSize(500, 400);  // Increased size for better layout
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on screen

        // Setting up the font and colors
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        Color bgColor = new Color(245, 245, 245);  // Light gray background color
        Color buttonColor = new Color(60, 179, 113);  // Medium sea green button color
        Color buttonTextColor = Color.WHITE;

        // Set background color
        getContentPane().setBackground(bgColor);

        // Components
        JLabel lblPreference = new JLabel("Preference:");
        lblPreference.setFont(labelFont);

        JTextField txtPreference = new JTextField(20);
        txtPreference.setFont(textFieldFont);

        JButton btnSave = new JButton("Save Preferences");
        btnSave.setBackground(buttonColor);
        btnSave.setForeground(buttonTextColor);
        btnSave.setFont(buttonFont);

        JButton btnBack = new JButton("Back to Dashboard");
        btnBack.setBackground(buttonColor);
        btnBack.setForeground(buttonTextColor);
        btnBack.setFont(buttonFont);

        // Add action listeners
        btnSave.addActionListener(e -> savePreferences(txtPreference.getText()));
        btnBack.addActionListener(e -> goBack());

        // Using GridBagLayout for an organized structure
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblPreference, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtPreference, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(btnSave, gbc);

        gbc.gridy = 2;
        add(btnBack, gbc);
    }

    // Method to save customer preferences and store them in the HashMap
    private void savePreferences(String preference) {
        if (preference.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a preference.");
            return;
        }

        // Add the preference to the HashMap (assuming one customer ID as "Customer1" for simplicity)
        String customerId = "Customer1";  // In a real system, this should be dynamically assigned based on the customer

        if (customerPreferences.containsKey(customerId)) {
            customerPreferences.get(customerId).add(preference);
        } else {
            ArrayList<String> preferencesList = new ArrayList<>();
            preferencesList.add(preference);
            customerPreferences.put(customerId, preferencesList);
        }

        // Display confirmation message
        JOptionPane.showMessageDialog(this, "Preference saved: " + preference);
    }

    private void goBack() {
        new MainDashboard().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        // Create a HashMap to store customer preferences
        HashMap<String, ArrayList<String>> customerPreferences = new HashMap<>();

        SwingUtilities.invokeLater(() -> new CustomerPreferencesPage(customerPreferences).setVisible(true));
    }
}


/**
 *
 * @author icc

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
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
