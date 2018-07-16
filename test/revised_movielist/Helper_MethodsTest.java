/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revised_movielist;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author J72507
 */
public class Helper_MethodsTest {
    
    /**
     * Test of check_valid_movie_name method, of class Helper_Methods.
     */
    @Test
    public void testCheck_valid_movie_name() {
        System.out.println("check_valid_movie_name");
        String name = "Default Name";
        Helper_Methods instance = new Helper_Methods();
        boolean expResult = true;
        boolean result = instance.check_valid_movie_name(name);
        assertEquals(expResult, result);
        
        name = "    ";
        expResult = false;
        result = instance.check_valid_movie_name(name);
        assertEquals(expResult, result);
        
        name = "";
        result = instance.check_valid_movie_name(name);
        assertEquals(expResult, result);
        
        name = null;
        result = instance.check_valid_movie_name(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of check_valid_movie_year method, of class Helper_Methods.
     */
    @Test
    public void testCheck_valid_movie_year() {
        System.out.println("check_valid_movie_year");
        String year = "1995";
        Helper_Methods instance = new Helper_Methods();
        boolean expResult = true;
        boolean result = instance.check_valid_movie_year(year);
        assertEquals(expResult, result);
        
        year = "    1995   ";
        result = instance.check_valid_movie_year(year);
        assertEquals(expResult, result);
        
        expResult = false;
        year = "0";
        result = instance.check_valid_movie_year(year);
        assertEquals(expResult, result);
        
        year = "-1995";
        result = instance.check_valid_movie_year(year);
        assertEquals(expResult, result);
        
        year = "199a";
        result = instance.check_valid_movie_year(year);
        assertEquals(expResult, result);
        
        year = "b";
        result = instance.check_valid_movie_year(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of create_movie method, of class Helper_Methods.
     */
    @Test
    public void testCreate_movie() {
        System.out.println("create_movie");
        JTextField name = new JTextField("Default Name");
        JTextField year = new JTextField("1995");
        Helper_Methods instance = new Helper_Methods();
        Movie expResult = new Movie("Default Name", 1995);
        Movie result = instance.create_movie(name, year);
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getYear(), result.getYear());
    }

    /**
     * Test of scrollable_movie_list method, of class Helper_Methods.
     */
    @Test
    public void testScrollable_movie_list() {
        System.out.println("scrollable_movie_list");
        Map<String, Movie> movie_map = new HashMap<>();
        int movie_count = 4;
        Movie m1 = new Movie("Default Name", 1995);
        Movie m2 = new Movie("Default Name", 1994);
        Movie m3 = new Movie("Other Name", 1995);
        Movie m4 = new Movie("A Name", 2000);
        movie_map.put(m1.getName().trim()+m1.getYear(), m1);
        movie_map.put(m2.getName().trim()+m2.getYear(), m2);
        movie_map.put(m3.getName().trim()+m3.getYear(), m3);
        movie_map.put(m4.getName().trim()+m4.getYear(), m4);
        Helper_Methods instance = new Helper_Methods();
        
        String[][] data = new String[movie_count][2];
        String[] columnNames = { "Name", "Year" };
        data[0][0] = "A Name";
        data[1][0] = "Default Name";
        data[2][0] = "Default Name";
        data[3][0] = "Other Name";
        //System.out.println(data[0][2]);
        data[0][1] = "2000";
        data[1][1] = "1994";
        data[2][1] = "1995";
        data[3][1] = "1995";
        JTable table = new JTable(data, columnNames);
        
        JTable expResult = table;
        JTable result = instance.scrollable_movie_list(movie_map, movie_count);
        assertEquals(expResult.getValueAt(0,0), result.getValueAt(0,0));
        assertEquals(expResult.getValueAt(0,1), result.getValueAt(0,1));
        assertEquals(expResult.getValueAt(1,0), result.getValueAt(1,0));
        assertEquals(expResult.getValueAt(1,1), result.getValueAt(1,1));
        assertEquals(expResult.getValueAt(2,0), result.getValueAt(2,0));
        assertEquals(expResult.getValueAt(2,1), result.getValueAt(2,1));
        assertEquals(expResult.getValueAt(3,0), result.getValueAt(3,0));
        assertEquals(expResult.getValueAt(3,1), result.getValueAt(3,1));
    }
    
}