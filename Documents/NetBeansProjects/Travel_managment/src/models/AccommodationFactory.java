/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class AccommodationFactory {
    public static Accommodation createAccommodation(String type) {
        switch (type) {
            case "Hotel":
                return new Hotel();
            case "Hostel":
                return new Hostel();
            case "Resort":
                return new Resort();
            default:
                return null;
        }
    }
}
