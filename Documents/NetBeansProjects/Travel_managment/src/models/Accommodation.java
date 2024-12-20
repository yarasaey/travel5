/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author icc
 */

public abstract class Accommodation {
    protected String name;

    public abstract void book();

    public String getName() {
        return name;
    }
}
