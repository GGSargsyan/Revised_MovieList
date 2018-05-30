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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main_Panel //extends JFrame
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
    // will have import buttons
    JPanel panel_04 = new JPanel(new GridBagLayout());
    // will have add movie fields
    JPanel panel_05 = new JPanel(new GridBagLayout());
    
    // Creates begin button for panel_01
    JButton click_to_start = new JButton("<html>Click to begin building<br />"
                                            + "your movie list!</html>");
    
    // Creates the create and import buttons for panel_02
    JButton create_new_list = new JButton("Create new list");
    JButton import_list = new JButton("Import list");
    
    // Creates the 4 main menu buttons for panel_03
    JButton add_to_list = new JButton("Add a movie");
    JButton remove_from_list = new JButton("Remove a movie");
    JButton search_in_list = new JButton("Search for movie");
    JButton export_to_excel = new JButton("Export your list");
    
    // Creates the Google Spreadsheet and Microsoft Excel buttons for panel_04
    JButton google_spreadsheet = new JButton("Google Spreadsheet");
    JButton microsoft_excel = new JButton("Microsoft Excel");
    
    // Creates the field texts for adding a movie on panel_05
    JTextField movie_name_entry = new JTextField("");
    JTextField movie_year_entry = new JTextField("");
    //JButton submit_movie_button = new JButton("Submit Movie");
    
    // Various labels used to display text
    JLabel label_01 = new JLabel("Choose an option");
    JLabel label_02 = new JLabel("Choose an import option");
    //JLabel label_03 = new JLabel("<html><p align=\"left\">Enter movie name:
    //                                + "</p></html>");
    //JLabel label_04 = new JLabel("<html><p align=\"left\">Enter movie year:
    //                                + "</p></html>");
    
    // Object array to collect movie information when adding a movie to the list
    public Object[] inputs = {"<html><p align=\"left\">Movie Name: </p></html>", 
                                movie_name_entry, "<html><p align=\"left\">"
                                + "Movie Year: </p></html>", movie_year_entry};
    
    Main_Panel()
    {
        // Create window frame dimensions
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        initComponent();
        
        initEvent();    

    }
    private void initComponent()
    {
        window.add(panel_01, BorderLayout.CENTER);
        
        // Set color for panels
        panel_01.setBackground(Color.LIGHT_GRAY);
        panel_02.setBackground(Color.LIGHT_GRAY);
        panel_03.setBackground(Color.LIGHT_GRAY);
        panel_04.setBackground(Color.LIGHT_GRAY);
        panel_05.setBackground(Color.LIGHT_GRAY);
        
        // Place begin button on panel 1
        panel_01.add(click_to_start);
        
        // Place option buttons on panel 2
        panel_02.add(create_new_list);
        panel_02.add(import_list);
        
        // Set visiblilty of all panels but panel_01 to false
        panel_01.setVisible(true);
        panel_02.setVisible(false);
        panel_03.setVisible(false);
        panel_04.setVisible(false);
        panel_05.setVisible(false);
    }
    
    private void initEvent()
    {
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
                import_list.setVisible(false);
                label_01.setVisible(false);
                window.add(panel_03, BorderLayout.WEST);
                panel_03.setVisible(true);
                create_main_menu_panel();
            }
        });
        
        import_list.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                create_new_list.setVisible(false);
                import_list.setVisible(false);
                label_01.setVisible(false);
                window.add(panel_04, BorderLayout.CENTER);
                panel_04.setVisible(true);
                create_first_import_panel();
            }
        });
        
        add_to_list.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                create_add_movie_menu_panel();
                
                add_to_list.setVisible(false);
                remove_from_list.setVisible(false);
                search_in_list.setVisible(false);
                export_to_excel.setVisible(false);
                
                //window.add(panel_05, BorderLayout.WEST);
                
                //panel_05.setVisible(true);
            }
        });
    }
    
    private void create_main_menu_panel()
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
    
    private void create_new_or_import_panel()
    {
        c.insets = new Insets(10,10,10,10);
        c.gridx = 1;
        c.gridy = 1;
        panel_02.add(create_new_list,c);
        c.gridx = 3;
        c.gridy = 1;
        panel_02.add(import_list,c);
        c.gridx = 2;
        c.gridy = 0;
        panel_02.add(label_01,c);
        label_01.setVisible(true);
    }
    
    private void create_first_import_panel()
    {
        c.insets = new Insets(10,10,10,10);
        c.gridx = 1;
        c.gridy = 1;
        panel_04.add(google_spreadsheet,c);
        c.gridx = 3;
        c.gridy = 1;
        panel_04.add(microsoft_excel,c);
        c.gridx = 2;
        c.gridy = 0;
        panel_04.add(label_02,c);
        label_02.setVisible(true);
    }
    
    private void create_add_movie_menu_panel()
    { 
        // showInputDialog
        int result = JOptionPane.showConfirmDialog(panel_05, inputs,
            "Enter Movie", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) 
        {
         // TODO: do something with inputs
        }
    }
}
