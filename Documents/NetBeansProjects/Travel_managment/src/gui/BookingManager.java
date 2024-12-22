/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author icc
 */
//singelton pattern
public class BookingManager {
    // Singleton instance
    private static BookingManager instance;

    // Private constructor to prevent instantiation
    private BookingManager() {
    }

    // Method to get the single instance of BookingManager
    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    // Flight booking method
    public void bookFlight(String destination, String date) {
        // Logic for flight booking
        System.out.println("Booking flight to " + destination + " on " + date);
        // You can add database logic here for flight booking
    }

    // Hotel booking method
    public void bookHotel(String hotelName, String checkInDate) {
        // Logic for hotel booking
        System.out.println("Booking hotel " + hotelName + " for " + checkInDate);
        // You can add database logic here for hotel booking
    }

    // Package booking method
    public void bookPackage(TravelPackage travelPackage) {
        // Logic for package booking
        System.out.println("Booking " + travelPackage.getPackageName() + " package");
        // You can add database logic here for package booking
    }
}

