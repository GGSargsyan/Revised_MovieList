/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revised_movielist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Main_Panel extends Helper_Methods
{
    // This is the frame that all the panels will live on
    public static JFrame window = new JFrame("Your Movie List");
    public GridBagConstraints c = new GridBagConstraints();
    public Map<String, Movie> unsorted_movies = new HashMap<>();
    int movie_count = 0;
    Dimension PREF_SIZE = new Dimension(150, 30);
    JTable table;
    JScrollPane myScrollPane;
        
    // These are the panels which will be populated
    // will have begin button
    JPanel panel_01 = new JPanel(new GridBagLayout());
    // will have new/import button
    JPanel panel_02 = new JPanel(new GridBagLayout());
    // will have main menu buttons
    JPanel panel_03 = new JPanel(new GridBagLayout());
    // will have import buttons
    JPanel panel_04 = new JPanel(new GridBagLayout());
    // will have scroll movies view
    JPanel panel_05 = new JPanel(new GridBagLayout());
    
    // Creates begin button for panel_01
    JButton click_to_start = new JButton("<html><p align=\"center\">Click to "
                                      + "begin building</p><br /><p align=\""
                                      + "center\">your movie list!</html></p>");
    
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
    
    // Array of strings and JTextFields to collect user entries
    public Object[] inputs = {"Movie Name:", movie_name_entry, 
                              "Movie Year:", movie_year_entry};
    
    Main_Panel()
    {
        // Create window frame dimensions
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        //panel_03.setLayout(new BoxLayout(panel_03, BoxLayout.Y_AXIS));
        
        initComponent();
        
        initEvent();    

    }
    private void initComponent()
    {
        window.add(panel_01, BorderLayout.CENTER);
        add_to_list.setPreferredSize(PREF_SIZE);
        remove_from_list.setPreferredSize(PREF_SIZE);
        search_in_list.setPreferredSize(PREF_SIZE);
        export_to_excel.setPreferredSize(PREF_SIZE);
        create_new_list.setPreferredSize(PREF_SIZE);
        import_list.setPreferredSize(PREF_SIZE);
                        
        // Set color for panels
        panel_01.setBackground(Color.LIGHT_GRAY);
        panel_02.setBackground(Color.LIGHT_GRAY);
        panel_03.setBackground(Color.LIGHT_GRAY);
        panel_04.setBackground(Color.LIGHT_GRAY);
        panel_05.setBackground(Color.LIGHT_GRAY);
        //panel_03.setLayout(new GridLayout(1,2));
        
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
                window.add(panel_05, BorderLayout.EAST);
                panel_03.setVisible(true);
                panel_05.setVisible(true);
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
                add_movie_dialog_box(unsorted_movies);
                movie_name_entry.setText("");
                movie_year_entry.setText("");
                refresh_main_panel();
            }
        });
        
        search_in_list.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                search_movie_dialog_box(unsorted_movies);
                movie_name_entry.setText("");
                movie_year_entry.setText("");
            }
        });
        
        remove_from_list.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                remove_movie_dialog_box(unsorted_movies);
                movie_name_entry.setText("");
                movie_year_entry.setText("");
                refresh_main_panel();
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
        
        c.gridx = 1;
        c.gridy = 1;
        table = scrollable_movie_list(unsorted_movies, movie_count);
        table.setPreferredScrollableViewportSize(new Dimension(250, 300));
        table.setFillsViewportHeight(true); 
        
        myScrollPane = new JScrollPane(table);
        
        panel_05.add(myScrollPane, c);
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
    
    private void movie_scroll_list()
    {
        c.insets = new Insets(10,10,10,10);
        c.gridx = 2;
        c.gridy = 1;
        table = scrollable_movie_list(unsorted_movies, movie_count);
        table.setPreferredScrollableViewportSize(new Dimension(250, 300));
        table.setFillsViewportHeight(true); 
        
        myScrollPane = new JScrollPane(table);
        
        panel_05.add(myScrollPane, c);
    }
    
    private void add_movie_dialog_box(Map<String, Movie> insert_map)
    { 
        // showInputDialog
        int result = JOptionPane.showConfirmDialog(panel_03, inputs,
            "Enter Movie", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) 
        {
            if ( check_valid_movie_name( movie_name_entry.getText()) )
            {
                if ( check_valid_movie_year( movie_year_entry.getText()) )
                {
                    // add movie to hashmap
                    Movie insert_movie = create_movie(movie_name_entry, 
                                                      movie_year_entry);
                    String key = insert_movie.getName()+insert_movie.getYear();
                    boolean key_exists = insert_map.containsKey(key);
                    if ( !key_exists )
                    {
                        // create new list if key mapping doesn't exist
                        insert_map.put(key, insert_movie);
                        JOptionPane.showMessageDialog(panel_03, "Movie "
                                + "successfully added!", "Complete", 
                                JOptionPane.PLAIN_MESSAGE);
                        movie_count++;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(panel_03, "Movie already"
                                + " in list!", "Complete", 
                                JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(panel_03, "Invalid movie year"
                        + " choice!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(panel_03, "Invalid movie name "
                        + "choice!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void search_movie_dialog_box(Map<String, Movie> search_map)
    { 
        // showInputDialog
        if (search_map.isEmpty())
        {
            JOptionPane.showMessageDialog(panel_03, "List is empty!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int result = JOptionPane.showConfirmDialog(panel_03, inputs,
            "Search Movie", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) 
        {
            if ( check_valid_movie_name( movie_name_entry.getText()) )
            {
                if ( check_valid_movie_year( movie_year_entry.getText()) )
                {
                    // find movie in hashmap
                    Movie search_movie = create_movie(movie_name_entry, 
                                                      movie_year_entry);
                    
                    String key = search_movie.getName()+search_movie.getYear();
                    
                    boolean found = search_map.containsKey( key );
                    
                    if ( !found )
                    {
                        JOptionPane.showMessageDialog(panel_03,"Movie not found"
                         + " in list!", "Not Found", JOptionPane.PLAIN_MESSAGE);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(panel_03, "Movie is in"
                                + " list!", "Found", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(panel_03, "Invalid movie year"
                        + " choice!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(panel_03, "Invalid movie name "
                        + "choice!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void remove_movie_dialog_box(Map<String, Movie> remove_map)
    {
        // showInputDialog
        if (remove_map.isEmpty())
        {
            JOptionPane.showMessageDialog(panel_03, "List is empty!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        int result = JOptionPane.showConfirmDialog(panel_03, inputs,
            "Remove Movie", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) 
        {
            if ( check_valid_movie_name( movie_name_entry.getText()) )
            {
                if ( check_valid_movie_year( movie_year_entry.getText()) )
                {
                    // find movie in hashmap
                    Movie remove_movie = create_movie(movie_name_entry, 
                                                      movie_year_entry);
                    
                    String key = remove_movie.getName()+remove_movie.getYear();
                    
                    if ( !remove_map.containsKey(key) )
                    {
                        JOptionPane.showMessageDialog(panel_03,"Movie not found"
                         + " in list!", "Not Found", JOptionPane.PLAIN_MESSAGE);
                    }
                    else 
                    {
                        System.out.println(remove_map);
                        remove_map.remove(key);
                        
                        JOptionPane.showMessageDialog(panel_03, "Movie removed "
                            + "from list!", "Found", JOptionPane.PLAIN_MESSAGE);
                        movie_count--;
                        System.out.println(remove_map);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(panel_03, "Invalid movie year"
                        + " choice!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(panel_03, "Invalid movie name "
                        + "choice!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void refresh_main_panel()
    {
        panel_05.setVisible(false);
        window.remove(panel_05);
        panel_05.removeAll();
        movie_scroll_list();
        panel_05.setVisible(true);
        window.add(panel_05, BorderLayout.EAST);
    }
}