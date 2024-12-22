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
/////////////////////////////adapter pattern//////////////
public interface PaymentGateway {
    void processPayment(double amount);
}
