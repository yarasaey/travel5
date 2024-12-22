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

/////////factory pattern////
public class AccommodationFactory {

    public static Accommodation getAccommodation(String accommodationType) {
        switch (accommodationType.toLowerCase()) {
            case "hotel":
                return new Hotel();
            case "hostel":
                return new Hostel();
            case "resort":
                return new Resort();
            default:
                throw new IllegalArgumentException("Unknown accommodation type: " + accommodationType);
        }
    }
}
