/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revised_movielist;

public class Movie 
{
    // Data members of movies
    private String movieName;
    private int movieYear;
    
    /**
     * This is the default constructor.
     */
    public Movie()
    {
        this.movieName = "";
        this.movieYear = 0;
    }
    
    /**
     * This constructor takes in all data members as arguments and creates 
     * a complete movies object to be used in MovieList.java
     * @param movieName
     * @param movieYear
     */
    public Movie(String movieName, int movieYear)
    {
        this.movieName = movieName;
        this.movieYear = movieYear;
    }
    
    /**
     * Accessor used to retrieve the name of a movies object
     * @return String movieName
     */
    public String getName()
    {
        return this.movieName;
    }
    
    /**
     * Accessor used to retrieve the name of a movies object
     * @return String movieName
     */
    public int getYear()
    {
        return this.movieYear;
    }
    
    /**
     * Mutator used to set a movies object's name.
     * @param name
     */
    public void setName(String name)
    {
        movieName = name;
    }
    
    /**
     * Mutator used to set a movies object's year.
     * @param year
     */
    public void setName(int year)
    {
        movieYear = year;
    }
}
