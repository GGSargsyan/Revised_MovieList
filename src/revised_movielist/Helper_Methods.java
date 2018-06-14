/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revised_movielist;

import java.util.Arrays;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.PriorityQueue;


class Helper_Methods 
{

    boolean check_valid_movie_name(String name) 
    {
        // checks if string is null, empty, or just whitespace
        return !((name == null) || "".equals(name.trim()));
    }
    
    
    boolean check_valid_movie_year(String year)
    {
        int test_inputted_movie_year = 0;
        try 
        {
            test_inputted_movie_year = Integer.parseInt( year.trim() );
            // check if year is a positive year
            if ( test_inputted_movie_year <= 0 )
            {
                return false;
            }
        }
        catch(NumberFormatException e) 
        { 
            return false;
        }
        return true;    
    }
    
    Movie create_movie(JTextField name, JTextField year)
    {
        String movie_name = name.getText().trim();
        int movie_year = Integer.parseInt(year.getText().trim());
        
        Movie new_movie = new Movie(movie_name, movie_year);
        return new_movie;
    }
    
    
    JTable scrollable_movie_list(Map<String, Movie> movie_map, int movie_count)
    {
        //System.out.println(movie_map);
        Movie[] movie_array = new Movie[movie_count];
        // fill array with movies
        //Set<String> setOfKeys = movie_map.keySet();
        
        int array_add_index = 0;
        // get all the keys
        for ( String key : movie_map.keySet() )
        {
            // for each key get its list
            movie_array[array_add_index] = movie_map.get(key);
            
            array_add_index++;
        }
        // we now have an array with all the movies of the movie_map to sort
        
        Arrays.sort(movie_array);
        
        // Now put each movie name and year into the jtable
        //DefaultTableModel table = new DefaultTableModel(movie_count, 0);
        String[][] data = new String[movie_count][2];
        for (int i = 0; i < movie_count; i++) 
        {
            for (int j = 0; j < 2; j++) 
            {
                if (j == 0)
                    data[i][j] = movie_array[i].getName();
                else
                    data[i][j] = Integer.toString(movie_array[i].getYear());
            }
        }
        String[] columnNames = { "Name", "Year" };
        JTable table = new JTable(data, columnNames);
        return table;
    }
    /*
    PriorityQueue<Movie> create_sorted_list( Movie[] unsorted_movies )
    {
        PriorityQueue<Movie> pq = new PriorityQueue<Movie>( new MovieComp() );
        for ( Movie m : unsorted_movies )
            pq.offer(m);
        return pq;
    }*/
}