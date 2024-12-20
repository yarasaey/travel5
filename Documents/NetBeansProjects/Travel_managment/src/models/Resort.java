/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

class Resort extends Accommodation {
    public Resort() {
        this.name = "Resort";
    }

    @Override
    public void book() {
        System.out.println("Resort booked successfully.");
    }
}
