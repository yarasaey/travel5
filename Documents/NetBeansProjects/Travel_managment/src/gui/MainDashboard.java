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
        setSize(600, 700);  // Increased size for better spacing
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on the screen

        // Initialize the HashMap with empty ArrayLists
        travelData.put("Flights", new ArrayList<>());
        travelData.put("Hotels", new ArrayList<>());
        travelData.put("Customers", new ArrayList<>());

        // Set background color or background image
        ImageIcon backgroundImage = new ImageIcon("path/to/your/image.jpg");  // If you have a background image
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);
        setLayout(new GridBagLayout());

        // Set background color and design
        Color buttonColor = new Color(100, 149, 237);  // Cornflower blue button color
        Color buttonTextColor = Color.WHITE;
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        // Buttons with enhanced design
        JButton btnFlightBooking = createStyledButton("Flight Booking", buttonColor, buttonTextColor, buttonFont);
        JButton btnHotelBooking = createStyledButton("Hotel Reservation", buttonColor, buttonTextColor, buttonFont);
        JButton btnCustomerPreferences = createStyledButton("Customer Preferences", buttonColor, buttonTextColor, buttonFont);
        JButton btnCreateCustomerProfile = createStyledButton("Customer Profile", buttonColor, buttonTextColor, buttonFont);
        JButton btnPackageSelection = createStyledButton("Travel Type", buttonColor, buttonTextColor, buttonFont);
        JButton btnAccommodationSelection = createStyledButton("Accommodation Selection", buttonColor, buttonTextColor, buttonFont);
        JButton btnClonePackage = createStyledButton("Travel Information", buttonColor, buttonTextColor, buttonFont);

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
            JOptionPane.showMessageDialog(this, "Customer Profile  " + customer);
        });

        // Button for cloning a travel package
        btnClonePackage.addActionListener(e -> {
            // Create an original tour package
            TourPackage originalPackage = new TourPackage("The destination and price", "Hawaii", 1200.0);

            // Clone the package
            TourPackage clonedPackage = originalPackage.clone();

            // Show cloned package details
            JOptionPane.showMessageDialog(this, "Travel: " + clonedPackage);
        });

        // Add buttons to layout with GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);  // Padding around buttons

        // Adding buttons to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(btnFlightBooking, gbc);

        gbc.gridy = 1;
        add(btnHotelBooking, gbc);

        gbc.gridy = 2;
        add(btnCustomerPreferences, gbc);

        gbc.gridy = 3;
        add(btnCreateCustomerProfile, gbc);

        gbc.gridy = 4;
        add(btnPackageSelection, gbc);

        gbc.gridy = 5;
        add(btnAccommodationSelection, gbc);

        // Add the Clone Package button
        gbc.gridy = 6;
        add(btnClonePackage, gbc);
    }

    // Helper method to create styled buttons
    private JButton createStyledButton(String text, Color bgColor, Color textColor, Font font) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFont(font);
        button.setPreferredSize(new Dimension(250, 50));  // Fixed size for consistency
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));  // Add border around button
        button.setFocusPainted(false);
        
        // Add hover effect for buttons
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180)); // Darker blue on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);  // Restore original color
            }
        });
        return button;
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
