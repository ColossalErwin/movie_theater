/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import ejb.movieEJB;
import entities.Theater;
import entities.Movie;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author hieutran
 */
@Named(value = "showTheaterBean")
@SessionScoped
public class ShowTheaterBean implements Serializable {

    
    @EJB
    private movieEJB movieEJB;
    private Theater theater;
    /**
     * Creates a new instance of ShowTheaterBean
     */
    public ShowTheaterBean() {
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String showTheater(Theater theater) {
        this.theater = theater;
        return "ShowTheater.xhtml" + "?faces-redirect=true";
    }
    
    
    public String backToTheater() {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String theaterid =  params.get("theaterid"); 
      theater = movieEJB.getTheater(theaterid);
      return "ShowTheater.xhtml" + "?faces-redirect=true";
    }
    
    public String showMoviesForTheater() {
        
    
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String theaterid =  params.get("theaterid"); 
      theater = movieEJB.getTheater(theaterid);
      
      return "Movies.xhtml" + "?faces-redirect=true";
    }
    
    public List<Movie> getMovieList()
    {
        if (theater != null)
           return movieEJB.getMoviesForTheater(theater.getTheaterid());
        else
           return null;
    }
    
    
}
