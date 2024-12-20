/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;






class Hostel extends Accommodation {
    public Hostel() {
        this.name = "Hostel";
    }

    @Override
    public void book() {
        System.out.println("Hostel booked successfully.");
    }
}

