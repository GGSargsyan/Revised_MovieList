/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revised_movielist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main_Panel extends JFrame
{
    // This is the frame that all the panels will live on
    public static JFrame window = new JFrame("Your Movie List");
    public GridBagConstraints c = new GridBagConstraints();
        
    // These are the panels which will be populated
    // will have begin button
    JPanel panel_01 = new JPanel(new GridBagLayout());
    // will have new/import button
    JPanel panel_02 = new JPanel(new GridBagLayout());
    // will have main menu buttons
    JPanel panel_03 = new JPanel(new GridBagLayout());
    
    // Creates begin button for panel_01
    JButton click_to_start = new JButton("<html>Click to begin building<br />"
                                            + "your movie list!</html>");
    // Creates the create and import buttons for panel_02
    JButton create_new_list = new JButton("Create new list");
    JButton import_list_in_excel = new JButton("Import list from excel");
    // Creates the 4 main menu buttons for panel_03
    JButton add_to_list = new JButton("Add a movie");
    JButton remove_from_list = new JButton("Remove a movie");
    JButton search_in_list = new JButton("Search for movie");
    JButton export_to_excel = new JButton("Export your list");
    
    // A label used to display text
    JLabel label_01 = new JLabel("Choose an option");
    
    Main_Panel()
    {
        // Create window frame dimensions
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        
        // Set color for panels
        panel_01.setBackground(Color.LIGHT_GRAY);
        panel_02.setBackground(Color.LIGHT_GRAY);
        panel_03.setBackground(Color.LIGHT_GRAY);
        
        // Place begin button on panel 1
        panel_01.add(click_to_start);
        
        // Place option buttons on panel 2
        panel_02.add(create_new_list);
        panel_02.add(import_list_in_excel);
        
        // Set visiblilty of all panels but panel_01 to false
        panel_01.setVisible(true);
        panel_02.setVisible(false);
        panel_03.setVisible(false);

        window.add(panel_01, BorderLayout.CENTER);
        
        click_to_start.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                window.remove(panel_01);
                label_01.setVisible(false);
                window.add(panel_02, BorderLayout.CENTER);
                panel_02.setVisible(true);
                create_new_or_import_panel();
            }
        });
        
        create_new_list.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                create_new_list.setVisible(false);
                import_list_in_excel.setVisible(false);
                label_01.setVisible(false);
                window.add(panel_03, BorderLayout.WEST);
                panel_03.setVisible(true);
                create_main_menu_panel();
            }
        });
    }
    
    public void create_main_menu_panel()
    { 
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        panel_03.add(add_to_list,c);
        c.gridx = 0;
        c.gridy = 2;
        panel_03.add(remove_from_list,c);
        c.gridx = 0;
        c.gridy = 3;
        panel_03.add(search_in_list,c);
        c.gridx = 0;
        c.gridy = 4;
        panel_03.add(export_to_excel,c);
        //window.add(panel_03, BorderLayout.WEST);
    }
    
    public void create_new_or_import_panel()
    {
        c.insets = new Insets(10,10,10,10);
        c.gridx = 1;
        c.gridy = 1;
        panel_02.add(create_new_list,c);
        c.gridx = 3;
        c.gridy = 1;
        panel_02.add(import_list_in_excel,c);
        //c.anchor = GridBagConstraints.NORTH;
        //panel_02.add(label_01,BorderLayout.NORTH);
        c.gridx = 2;
        c.gridy = 0;
        panel_02.add(label_01,c);
        label_01.setVisible(true);
    }
}
