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
////////////////adaptor pattern//////////////////
public class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing PayPal payment of " + amount + " dollars.");
    }
}