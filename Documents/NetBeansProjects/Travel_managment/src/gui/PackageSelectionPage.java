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
import java.util.ArrayList;
import java.util.HashMap;

////////////////////////////////singelton pattern//////////
public class PackageSelectionPage extends JFrame {

    // HashMap to store user and their selected packages
    private HashMap<String, ArrayList<String>> customerPackages;

    public PackageSelectionPage() {
        setTitle("Trip type");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window

        // Initialize the HashMap
        customerPackages = new HashMap<>();

        // Setting up the font and colors
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color bgColor = new Color(230, 230, 250);  // Lavender background color
        Color buttonColor = new Color(100, 149, 237);  // Cornflower blue button color
        Color buttonTextColor = Color.WHITE;

        // Set background color
        getContentPane().setBackground(bgColor);

        // Components
        JLabel lblPackage = new JLabel("Select your type:");
        lblPackage.setFont(new Font("Arial", Font.PLAIN, 14));

        String[] packageOptions = { "Luxury", "Adventure", "Cultural" };
        JComboBox<String> comboPackage = new JComboBox<>(packageOptions);
        comboPackage.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton btnSelectPackage = new JButton("submit");
        btnSelectPackage.setBackground(buttonColor);
        btnSelectPackage.setForeground(buttonTextColor);
        btnSelectPackage.setFont(buttonFont);

        // Action listener to create a package using TravelPackageFactory
        btnSelectPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPackage = (String) comboPackage.getSelectedItem();

                // Assume we have a user identifier, here it's hardcoded as "user1"
                String userId = "user1";  // This should be dynamically assigned based on actual user authentication.

                // If the user already has selected packages, add the new package to their list
                customerPackages.putIfAbsent(userId, new ArrayList<>());
                customerPackages.get(userId).add(selectedPackage);

                // Simulate booking the package using the TravelPackageFactory (this would be connected to actual backend logic)
                TravelPackage travelPackage = TravelPackageFactory.getTravelPackage(selectedPackage);

                // Book the selected package using BookingManager
                BookingManager.getInstance().bookPackage(travelPackage);

                JOptionPane.showMessageDialog(PackageSelectionPage.this, "Booked " + travelPackage.getPackageName() + " package for " + userId);
            }
        });

        JButton btnBack = new JButton("Back to Dashboard");
        btnBack.setBackground(buttonColor);
        btnBack.setForeground(buttonTextColor);
        btnBack.setFont(buttonFont);
        btnBack.addActionListener(e -> goBack());

        // Layout setup using GridBagLayout for alignment and spacing
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);  // Padding around components

        // Add components to layout with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblPackage, gbc);

        gbc.gridy = 1;
        add(comboPackage, gbc);

        gbc.gridy = 2;
        add(btnSelectPackage, gbc);

        gbc.gridy = 3;
        add(btnBack, gbc);
    }

    // Method to go back to the main dashboard
    private void goBack() {
        new MainDashboard().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PackageSelectionPage().setVisible(true));
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
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
