/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revised_movielist;

import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ed
 */
public class Revised_MovieList
{
    /**
     * @param args the command line arguments
     */
    
    public static JFrame window_frame = new JFrame("Your Movie List");
    /*public JFrame window = new JFrame("Your Movie List");
    
    
    public Revised_MovieList()
    {
        main_menu_gui();
    }
    
    public void main_menu_gui()
    {
        window = new JFrame("Your Movie List");
        window.setVisible(true);
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    */
    public static void main(String[] args) 
    {
        //use_main_panel();
        //new Revised_MovieList();
        Main_Panel mp = new Main_Panel();
    }
    
}
