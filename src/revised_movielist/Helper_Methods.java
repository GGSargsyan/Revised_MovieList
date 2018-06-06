
package revised_movielist;

import java.util.List;
import javax.swing.JTextField;


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
    
    
    boolean search_movie_in_list(Movie input_movie, List<Movie> input_list)
    {
        for ( Movie m : input_list)
        {
            if ( input_movie.getName().equals( m.getName() ) && 
                 input_movie.getYear() == m.getYear() )
            {
                return true;
            }
        }
        return false;
    }
    
    
    Movie create_movie(JTextField name, JTextField year)
    {
        String movie_name = name.getText().trim();
        int movie_year = Integer.parseInt(year.getText().trim());
        
        Movie new_movie = new Movie(movie_name, movie_year);
        return new_movie;
    }
    
}