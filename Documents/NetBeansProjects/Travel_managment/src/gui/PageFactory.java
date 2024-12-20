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
public class PageFactory {
       public static JFrame getPage(String pageType) {
        switch (pageType) {
            case "Dashboard":
                return new MainDashboard();
            case "FlightBooking":
                return new FlightBookingPage();
            case "HotelReservation":
                return new HotelReservationPage();
            case "CustomerPreferences":
                return new CustomerPreferencesPage();
            default:
                return null;
        }
    }
}
    
}

