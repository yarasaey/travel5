/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class LuxuryPackage extends TravelPackage {
    public LuxuryPackage() {
        this.name = "Luxury Package";
        this.description = "Experience the finest luxury accommodations and services.";
    }

    @Override
    public void displayDetails() {
        System.out.println("Package: " + name);
        System.out.println("Description: " + description);
    }
}