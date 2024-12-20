/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

  
import java.util.ArrayList;
import java.util.List;

public class UserProfileManager {
    // Singleton instance
    private static UserProfileManager instance;

    private String userName;
    private int loyaltyPoints;
    private List<String> bookingHistory;

    // Private constructor to prevent instantiation
    private UserProfileManager() {
        bookingHistory = new ArrayList<>();
        loyaltyPoints = 0;
    }

    // Method to get the single instance of UserProfileManager
    public static UserProfileManager getInstance() {
        if (instance == null) {
            instance = new UserProfileManager();
        }
        return instance;
    }

    // Methods to manage user profile
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addBookingToHistory(String booking) {
        bookingHistory.add(booking);
    }

    public List<String> getBookingHistory() {
        return bookingHistory;
    }
}
