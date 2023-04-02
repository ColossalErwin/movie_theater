/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import ejb.movieEJB;
import entities.Genre;
import entities.Movie;
import entities.Showtime;
import entities.Theater;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author hieutran
 */
@Named(value = "showMovieBean")
@SessionScoped
public class ShowMovieBean implements Serializable {

    @EJB
    private movieEJB movieEJB;
    private Movie movie;
    private Theater theater;
    private String showtime;

    public ShowMovieBean() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    



    public String showMovie(Movie movie, Theater theater) {
        this.movie = movie;
        this.theater = theater;
        return "ShowMovie.xhtml" + "?faces-redirect=true";
    }
    
    
    public String backToMovie() {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String movieid =  params.get("movieid"); 
      movie = movieEJB.getMovie(movieid);
      return "ShowMovie.xhtml" + "?faces-redirect=true";
    }
    
    
    
    public String showBuyingTicketForMovie() {
        
    
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String movieid =  params.get("movieid");
      movie = movieEJB.getMovie(movieid);
      showtime = params.get("chosenShowtime");
      
      return "BuyingTicket.xhtml" + "?faces-redirect=true";
    }
    
    
    
    
    public List<Genre> getGenreList()
    {
        if (movie != null)
           return movieEJB.getGenresForMovie(movie.getMovieid());
        else
           return null;
    }
    
    public List<Showtime> getShowtimeList()
    {
        if (movie != null)
           return movieEJB.getShowtimesForMovieForTheater(movie, theater);
        else
           return null;
    }
    
    
}
