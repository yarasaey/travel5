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
////////////////////////////////////////singlton pattern////
public class TravelPackageFactory {

    public static TravelPackage getTravelPackage(String packageType) {
        switch (packageType.toLowerCase()) {
            case "luxury":
                return new LuxuryPackage();
            case "adventure":
                return new AdventurePackage();
            case "cultural":
                return new CulturalPackage();
            default:
                throw new IllegalArgumentException("Unknown package type: " + packageType);
        }
    }
}

