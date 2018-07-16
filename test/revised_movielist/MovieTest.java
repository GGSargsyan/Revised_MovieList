/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revised_movielist;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author J72507
 */
public class MovieTest {
    
    /**
     * Test of getName method, of class Movie.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Movie instance = new Movie("Default Name", 1995);
        String expResult = "Default Name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Movie.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Movie instance = new Movie("Default Name", 1995);
        int expResult = 1995;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Movie.
     */
    @Test
    public void testSetName_String() {
        System.out.println("setName");
        String name = "Not Default Name";
        Movie instance = new Movie("Default Name", 1995);
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of setName method, of class Movie.
     */
    @Test
    public void testSetYear_int() {
        System.out.println("setName");
        int year = 1996;
        Movie instance = new Movie("Default Name", 1995);
        instance.setYear(year);
        assertEquals(year, instance.getYear());
    }

    /**
     * Test of Custom_toString method, of class Movie.
     */
    @Test
    public void testCustom_toString() {
        System.out.println("Custom_toString");
        Movie instance = new Movie("Default Name", 1995);
        String expResult = "Default Name1995";
        String result = instance.Custom_toString();
        assertEquals(expResult, result);
    }
    
}