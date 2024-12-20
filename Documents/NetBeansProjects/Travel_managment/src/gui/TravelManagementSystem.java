/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author icc
 */
public class TravelManagementSystem {
     public static void main(String[] args) {
        JFrame dashboard = PageFactory.getPage("Dashboard");
        dashboard.setVisible(true);
    }
    
}
