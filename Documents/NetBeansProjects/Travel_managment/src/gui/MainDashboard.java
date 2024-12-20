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

public class MainDashboard extends JFrame {
    // HashMap to store the data
    private HashMap<String, ArrayList<String>> travelData = new HashMap<>();

    public MainDashboard() {
        setTitle("Travel Management System - Dashboard");
        setSize(500, 500);  // Increased size for better spacing
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on the screen

        // Initialize the HashMap with empty ArrayLists
        travelData.put("Flights", new ArrayList<>());
        travelData.put("Hotels", new ArrayList<>());
        travelData.put("Customers", new ArrayList<>());

        // Setting up the font and colors
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color bgColor = new Color(230, 230, 250);  // Lavender background color
        Color buttonColor = new Color(100, 149, 237);  // Cornflower blue button color
        Color buttonTextColor = Color.WHITE;

        // Set background color
        getContentPane().setBackground(bgColor);

        // Components (Buttons)
        JButton btnFlightBooking = new JButton("Flight Booking");
        btnFlightBooking.setBackground(buttonColor);
        btnFlightBooking.setForeground(buttonTextColor);
        btnFlightBooking.setFont(buttonFont);

        JButton btnHotelBooking = new JButton("Hotel Reservation");
        btnHotelBooking.setBackground(buttonColor);
        btnHotelBooking.setForeground(buttonTextColor);
        btnHotelBooking.setFont(buttonFont);

        JButton btnCustomerPreferences = new JButton("Customer Preferences");
        btnCustomerPreferences.setBackground(buttonColor);
        btnCustomerPreferences.setForeground(buttonTextColor);
        btnCustomerPreferences.setFont(buttonFont);

        // New Button to create and display a customer profile
        JButton btnCreateCustomerProfile = new JButton("Create Customer Profile");
        btnCreateCustomerProfile.setBackground(buttonColor);
        btnCreateCustomerProfile.setForeground(buttonTextColor);
        btnCreateCustomerProfile.setFont(buttonFont);

        // New Button to open the PackageSelectionPage
        JButton btnPackageSelection = new JButton("Package Selection");
        btnPackageSelection.setBackground(buttonColor);
        btnPackageSelection.setForeground(buttonTextColor);
        btnPackageSelection.setFont(buttonFont);

        // New Button to open the AccommodationSelectionPage
        JButton btnAccommodationSelection = new JButton("Accommodation Selection");
        btnAccommodationSelection.setBackground(buttonColor);
        btnAccommodationSelection.setForeground(buttonTextColor);
        btnAccommodationSelection.setFont(buttonFont);

        // Add action listeners to buttons
        btnFlightBooking.addActionListener(e -> openFlightBooking());
        btnHotelBooking.addActionListener(e -> openHotelBooking());
        btnCustomerPreferences.addActionListener(e -> openCustomerPreferences());
        btnPackageSelection.addActionListener(e -> openPackageSelection());
        btnAccommodationSelection.addActionListener(e -> openAccommodationSelection());

        // Action listener for creating a customer profile
        btnCreateCustomerProfile.addActionListener(e -> {
            // Build a customer profile using the builder
            CustomerProfile customer = new CustomerProfile.CustomerBuilder("Jane Doe", "jane.doe@example.com")
                    .phoneNumber("555-1234")
                    .preferences("Window seat, Vegan meal")
                    .address("123 Maple Street, City, Country")
                    .build();

            // Print the customer profile
            System.out.println(customer);

            // Optionally show it in a dialog
            JOptionPane.showMessageDialog(this, "Customer Profile created: " + customer);
        });

        // Layout setup using GridBagLayout for alignment and spacing
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);  // Padding around buttons

        // Add buttons to layout with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnFlightBooking, gbc);

        gbc.gridy = 1;
        add(btnHotelBooking, gbc);

        gbc.gridy = 2;
        add(btnCustomerPreferences, gbc);

        gbc.gridy = 3;
        add(btnCreateCustomerProfile, gbc);

        // Add the new button for Package Selection
        gbc.gridy = 4;
        add(btnPackageSelection, gbc);

        // Add the new button for Accommodation Selection
        gbc.gridy = 5;
        add(btnAccommodationSelection, gbc);
    }

    // Method to open the Flight Booking page and pass the HashMap
    private void openFlightBooking() {
        new FlightBookingPage(travelData).setVisible(true);
        this.dispose(); // Closes current window
    }

    private void openHotelBooking() {
        new HotelReservationPage(travelData).setVisible(true);
        this.dispose();
    }

    private void openCustomerPreferences() {
        new CustomerPreferencesPage(travelData).setVisible(true);
        this.dispose();
    }

    // Method to open the PackageSelectionPage
    private void openPackageSelection() {
        new PackageSelectionPage().setVisible(true);
        this.dispose();  // Close the dashboard window
    }

    // Method to open the AccommodationSelectionPage
    private void openAccommodationSelection() {
        new AccommodationSelectionPage().setVisible(true);
        this.dispose();  // Close the dashboard window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
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
    
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
