/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revised_movielist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main_Panel extends JFrame
{
    // This is the frame that all the panels will live on
    JFrame window = new JFrame("Your Movie List");
    
    // These are the panels which will be populated
    // will have begin button
    JPanel panel_01 = new JPanel(new GridBagLayout());
    // will have new/import button
    JPanel panel_02 = new JPanel(new GridBagLayout());
    
    // Places begin button upon the first panel
    JButton click_to_start = new JButton("<html>Click to begin building<br />"
                                            + "your movie list!</html>");
    JButton create_new_list = new JButton("Create new list");
    JButton import_list_in_excel = new JButton("Import list from excel");
    // A label used to display text
    JLabel label_01 = new JLabel("Choose an option");
    
    Main_Panel()
    {
        // Create window frame dimensions
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        // Set color for panel 1
        panel_01.setBackground(Color.LIGHT_GRAY);
        // Set color for panel 2
        panel_02.setBackground(Color.LIGHT_GRAY);
        // Place begin button on panel 1
        panel_01.add(click_to_start);
        //Place option buttons on panel 2
        panel_02.add(create_new_list);
        panel_02.add(import_list_in_excel);
        
        // Add 
        panel_02.setVisible(false);
        
        window.add(panel_01, BorderLayout.CENTER);
        //window.add(panel_02, BorderLayout.CENTER);
        
        click_to_start.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                window.remove(panel_01);
                window.add(panel_02, BorderLayout.CENTER);
                panel_02.setVisible(true);
                panel_02.add(label_01);
                label_01.setVisible(true);
            }
        });
        
        create_new_list.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new Revised_MovieList();
                window.remove(panel_02);
            }
        });
    }
    
}
