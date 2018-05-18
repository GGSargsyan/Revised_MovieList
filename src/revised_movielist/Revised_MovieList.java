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
    
    //private static JFrame window_frame = new JFrame("Your Movie List");
    private static JFrame window = new JFrame("Your Movie List");
    private JPanel p;
    private JButton add_to_list, remove_from_list, search_in_list, 
                    export_to_excel;
    
    private JPanel panel_03 = new JPanel(new GridBagLayout());
    
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
        
        //p = new JPanel(new GridBagLayout());
        //p.setBackground(Color.YELLOW);
        
        add_to_list = new JButton("Add a movie");
        remove_from_list = new JButton("Remove a movie");
        search_in_list = new JButton("Search for movie");
        export_to_excel = new JButton("Export your list");
        //lab = new JLabel("This is test label");
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        panel_03.add(add_to_list,c);
        //p.add(lab);
        c.gridx = 0;
        c.gridy = 2;
        panel_03.add(remove_from_list,c);
        c.gridx = 0;
        c.gridy = 3;
        panel_03.add(search_in_list,c);
        c.gridx = 0;
        c.gridy = 4;
        panel_03.add(export_to_excel,c);
        
        //f.add(p, BorderLayout.NORTH);
        window.add(panel_03, BorderLayout.WEST);
    }
    
    public static void main(String[] args) 
    {
        //use_main_panel();
        //new Revised_MovieList();
        Main_Panel mp = new Main_Panel();
    }
    
}
