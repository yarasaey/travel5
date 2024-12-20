/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;



public abstract class TravelPackage {
    protected String name;
    protected String description;

    public abstract void displayDetails();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void createPackage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}