package gui;

import models.Accommodation;
import models.AccommodationFactory;
import models.TravelPackage;
import models.TravelPackageFactory;
import managers.BookingManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingPanel extends JPanel {
    private JComboBox<String> packageComboBox;
    private JComboBox<String> accommodationComboBox;
    private JButton bookButton;
    private JTextArea outputArea;

    public BookingPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null); // Consider using a layout manager instead of null

        // Travel Package Selection
        JLabel packageLabel = new JLabel("Select Travel destination:");
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
        bookButton = new JButton("Book");
        bookButton.setBounds(150, 120, 100, 30);
        add(bookButton);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setBounds(20, 160, 350, 80);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        // Action Listener for Book Button
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPackage = (String) packageComboBox.getSelectedItem();
                String selectedAccommodation = (String) accommodationComboBox.getSelectedItem();

                // Create Travel Package
                TravelPackage travelPackage = TravelPackageFactory.createPackage(selectedPackage);
                if (travelPackage != null) {
                    travelPackage.createPackage();
                    BookingManager.getInstance().book("Travel Package: " + selectedPackage);
                }

                // Create Accommodation
                Accommodation accommodation = AccommodationFactory.createAccommodation(selectedAccommodation);
                if (accommodation != null) {
                    accommodation.book();
                    BookingManager.getInstance().book("Accommodation: " + selectedAccommodation);
                }

                // Display bookings
                outputArea.setText("Bookings:\n" + String.join("\n", BookingManager.getInstance().getBookings()));
            }
        });
    }

    public static void main(String[] args) {
        // Create a frame to hold the BookingPanel
        JFrame frame = new JFrame("Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame

        // Add the BookingPanel to the frame
        BookingPanel bookingPanel = new BookingPanel();
        frame.add(bookingPanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

 
 /**
     * @param args the command line arguments
     */

        /* Create and display the form */
        
    /* Set the Nimbus look and feel */
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

