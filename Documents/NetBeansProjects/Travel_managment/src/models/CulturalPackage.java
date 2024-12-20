/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class CulturalPackage extends TravelPackage {
    public CulturalPackage() {
        this.name = "Cultural Package";
        this.description = "Immerse yourself in the local culture and traditions.";
    }

    @Override
    public void displayDetails() {
        System.out.println("Package: " + name);
        System.out.println("Description: " + description);
    }
}