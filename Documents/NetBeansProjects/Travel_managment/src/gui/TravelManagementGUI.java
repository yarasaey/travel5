/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// File: gui/TravelManagementSystemGUI.java
package gui;

import models.Accommodation;
import models.AccommodationFactory;
import models.TravelPackage;
import models.TravelPackageFactory;
import managers.BookingManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TravelManagementGUI extends JFrame {
    private JComboBox<String> packageComboBox;
    private JComboBox<String> accommodationComboBox;
    private JButton bookButton;
    private JTextArea outputArea; // Declare outputArea

    public TravelManagementGUI() {
        setTitle("Travel Management System");
        setSize(400, 400); // Increased size to accommodate output area
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Travel Package Selection
        JLabel packageLabel = new JLabel("Select Travel Package:");
        packageLabel.setBounds(20, 20, 200, 30);
        add(packageLabel);

        packageComboBox = new JComboBox<>(new String[]{"Luxury", "Adventure", "Cultural"});
        packageComboBox.setBounds(200, 20, 150, 30);
        add(packageComboBox);

        // Accommodation Selection
        JLabel accommodationLabel = new JLabel("Select Accommodation:");
        accommodationLabel.setBounds(20, 70, 200, 30);
        add(accommodationLabel);

        accommodationComboBox = new JComboBox<>(new String[]{"Hotel", "Hostel", "Resort"});
        accommodationComboBox.setBounds(200, 70, 150, 30);
        add(accommodationComboBox);

        // Book Button
        bookButton = new JButton("Book"); // Initialize the button
        bookButton.setBounds(150, 120, 100, 30);
        add(bookButton);

        // Output Area
        outputArea = new JTextArea(); // Initialize outputArea
        outputArea.setBounds(20, 160, 350, 200); // Set bounds for output area
        outputArea.setEditable(false);
        add(outputArea);

        // Action Listener for Book Button
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPackage = (String) packageComboBox.getSelectedItem();
                String selectedAccommodation = (String) accommodationComboBox.getSelectedItem();

                // Create Travel Package
                TravelPackage travelPackage = TravelPackageFactory.createPackage(selectedPackage);
                if (travelPackage != null) {
                    // Display package details (or any other relevant action)
                    travelPackage.displayDetails(); // Assuming you want to show details in console
                    BookingManager.getInstance().book("Travel Package: " + travelPackage.getName());
                }

                // Create Accommodation
                Accommodation accommodation = AccommodationFactory.createAccommodation(selectedAccommodation);
                if (accommodation != null) {
                    accommodation.book(); // Assuming this method performs the booking
                    BookingManager.getInstance().book("Accommodation: " + accommodation.getName());
                }

                // Display bookings
                List<String> bookings = BookingManager.getInstance().getBookings();
                if (bookings != null && !bookings.isEmpty()) {
                    outputArea.setText("Bookings:\n" + String.join("\n", bookings));
                } else {
                    outputArea.setText("No bookings made yet.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TravelManagementGUI gui = new TravelManagementGUI();
            gui.setVisible(true);
        });
    }
}
