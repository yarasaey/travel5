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
//////////////////////factory pattern/////////////////
public class Resort implements Accommodation {
    @Override
    public String getAccommodationType() {
        return "Resort Accommodation";
    }
}
