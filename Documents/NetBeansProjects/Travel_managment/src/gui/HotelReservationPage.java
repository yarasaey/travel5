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
////////////////////////HotelReservationPage///////
public class HotelReservationPage extends JFrame {

    // Declare the HashMap to store hotel reservations
    private HashMap<String, ArrayList<String>> hotelReservations;

    public HotelReservationPage(HashMap<String, ArrayList<String>> hotelReservations) {
        // Initialize the HashMap passed from the main class
        this.hotelReservations = hotelReservations;

        setTitle("Hotel Reservation");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center window on screen

        // Setting up the font and colors
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        Color bgColor = new Color(245, 245, 245);  // Light gray background color
        Color buttonColor = new Color(70, 130, 180);  // Steel blue button color
        Color buttonTextColor = Color.WHITE;

        // Set background color
        getContentPane().setBackground(bgColor);

        // Components
        JLabel lblHotelName = new JLabel("Hotel Name:");
        lblHotelName.setFont(labelFont);

        JTextField txtHotelName = new JTextField(20);
        txtHotelName.setFont(textFieldFont);

        JLabel lblCheckIn = new JLabel("Check-in Date (YYYY-MM-DD):");
        lblCheckIn.setFont(labelFont);

        JTextField txtCheckIn = new JTextField(20);
        txtCheckIn.setFont(textFieldFont);

        JButton btnReserve = new JButton("Reserve Hotel");
        btnReserve.setBackground(buttonColor);
        btnReserve.setForeground(buttonTextColor);
        btnReserve.setFont(buttonFont);

        JButton btnBack = new JButton("Back to Dashboard");
        btnBack.setBackground(buttonColor);
        btnBack.setForeground(buttonTextColor);
        btnBack.setFont(buttonFont);

        // Add action listeners for the Reserve button
        btnReserve.addActionListener(e -> {
            String hotelName = txtHotelName.getText();
            String checkInDate = txtCheckIn.getText();
            reserveHotel(hotelName, checkInDate);
        });

        // Action listener to navigate back to the main dashboard
        btnBack.addActionListener(e -> {
            new MainDashboard().setVisible(true);
            this.dispose();
        });

        // Layout settings
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblHotelName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtHotelName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblCheckIn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtCheckIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(btnReserve, gbc);

        gbc.gridy = 3;
        add(btnBack, gbc);
    }

    // Method to reserve a hotel and store it in the HashMap
    private void reserveHotel(String hotelName, String checkInDate) {
        if (hotelName.isEmpty() || checkInDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both hotel name and check-in date.");
            return;
        }

        // Add to HashMap
        if (hotelReservations.containsKey(hotelName)) {
            hotelReservations.get(hotelName).add(checkInDate);
        } else {
            ArrayList<String> checkInDates = new ArrayList<>();
            checkInDates.add(checkInDate);
            hotelReservations.put(hotelName, checkInDates);
        }

        // Display confirmation message
        JOptionPane.showMessageDialog(this, "Hotel reserved: " + hotelName + " on " + checkInDate);
    }

    public static void main(String[] args) {
        // Create a HashMap to store hotel reservations
        HashMap<String, ArrayList<String>> hotelReservations = new HashMap<>();
        
        SwingUtilities.invokeLater(() -> new HotelReservationPage(hotelReservations).setVisible(true));
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
            java.util.logging.Logger.getLogger(HotelReservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotelReservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotelReservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelReservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
