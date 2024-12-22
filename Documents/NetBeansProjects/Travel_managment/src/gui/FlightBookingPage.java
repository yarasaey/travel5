/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
///////////////////////flightbooking gui////////////////////
public class FlightBookingPage extends JFrame {

    // Declare a HashMap where the key is the destination and the value is a list of dates for that destination
    private HashMap<String, ArrayList<String>> flightBookings;

    public FlightBookingPage(HashMap<String, ArrayList<String>> flightBookings) {
        this.flightBookings = flightBookings;  // Initialize the passed HashMap

        setTitle("Flight Booking");
        setSize(500, 400);  // Increased the window size for better UI space
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centers the window on screen

        // Setting up the font and colors
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Color bgColor = new Color(224, 255, 255);  // Light cyan background color
        Color buttonColor = new Color(70, 130, 180);  // Steel blue color for buttons
        Color buttonTextColor = Color.WHITE;

        // Set background color
        getContentPane().setBackground(bgColor);

        // Components
        JLabel lblDestination = new JLabel("Destination:");
        lblDestination.setFont(labelFont);

        JTextField txtDestination = new JTextField(20);
        txtDestination.setFont(textFieldFont);

        JLabel lblDate = new JLabel("Date (YYYY-MM-DD):");
        lblDate.setFont(labelFont);

        JTextField txtDate = new JTextField(20);
        txtDate.setFont(textFieldFont);

        JButton btnBook = new JButton("Book Flight");
        btnBook.setBackground(buttonColor);
        btnBook.setForeground(buttonTextColor);
        btnBook.setFont(labelFont);

        JButton btnBack = new JButton("Back to Dashboard");
        btnBack.setBackground(buttonColor);
        btnBack.setForeground(buttonTextColor);
        btnBack.setFont(labelFont);

        // Add action listener to book a flight using the HashMap
        btnBook.addActionListener((ActionEvent e) -> {
            String destination = txtDestination.getText();
            String date = txtDate.getText();

            // If the destination is already in the HashMap, get its list of dates and add the new date
            if (flightBookings.containsKey(destination)) {
                flightBookings.get(destination).add(date);
            } else {
                // If the destination doesn't exist in the HashMap, create a new list of dates
                ArrayList<String> dates = new ArrayList<>();
                dates.add(date);
                flightBookings.put(destination, dates);
            }

            // Show confirmation
            JOptionPane.showMessageDialog(null, "Flight booked successfully to " + destination + " on " + date);
            
            // Print the updated flight bookings to the console for verification
            System.out.println("Updated flight bookings: " + flightBookings);
        });

        // Action listener to navigate back to the main dashboard
        btnBack.addActionListener(e -> {
            new MainDashboard().setVisible(true);  // Opens the main dashboard
            this.dispose();  // Closes the current page
        });

        // Using GridBagLayout for a clean, organized layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblDestination, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtDestination, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblDate, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(btnBook, gbc);

        gbc.gridy = 3;
        add(btnBack, gbc);
    }

    public static void main(String[] args) {
        // Create a HashMap to store flight bookings
        HashMap<String, ArrayList<String>> flightBookings = new HashMap<>();
        
        SwingUtilities.invokeLater(() -> {
            new FlightBookingPage(flightBookings).setVisible(true);
        });
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

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
