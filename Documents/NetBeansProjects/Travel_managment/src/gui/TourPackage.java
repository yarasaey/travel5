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


public class TourPackage implements Cloneable {
    private String name;
    private String destination;
    private double price;

    // Constructor
    public TourPackage(String name, String destination, double price) {
        this.name = name;
        this.destination = destination;
        this.price = price;
    }

    // Getter and Setter methods (optional, based on use cases)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override the clone method for the Prototype Pattern
    @Override
    public TourPackage clone() {
        try {
            return (TourPackage) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported for TourPackage class", e);
        }
    }

    // Override toString for better display in dialogs or logs
    @Override
    public String toString() {
        return "TourPackage{" +
                "name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }
}

