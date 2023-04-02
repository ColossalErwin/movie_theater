/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import entities.Genre;
import entities.Location;
import entities.Movie;
import entities.Showtime;
import entities.Theater;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class movieEJB {
    @PersistenceContext(unitName = "JSFParmsPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    
    public List<Location> findAllLocations()
    {
        return em.createNamedQuery("Location.findAll", Location.class).getResultList(); 
    }
    
    public Location getLocation(String zipcode)
    {
        return em.createNamedQuery("Location.findByZipcode", Location.class)
                .setParameter("zipcode", zipcode)
                .getSingleResult();
    }
    public List<Theater> getTheatersForLocation(String zipcode)
    {
        return em.createNamedQuery("Location.findTheatersByLocation", Theater.class)
                .setParameter("zipcode", zipcode)
                .getResultList();
    }
    
    
    //For Theater
    public List<Theater> findAllTheaters()
    {
        return em.createNamedQuery("Theater.findAll", Theater.class).getResultList(); 
    }
    
    public Theater getTheater(String theaterid)
    {
        return em.createNamedQuery("Theater.findByTheaterid", Theater.class)
                .setParameter("theaterid", theaterid)
                .getSingleResult();
    }
    public List<Movie> getMoviesForTheater(String theaterid)
    {
        return em.createNamedQuery("Theater.findMoviesByTheater", Movie.class)
                .setParameter("theaterid", theaterid)
                .getResultList();
    }
    
    //For Movie
    public List<Movie> findAllMovies()
    {
        return em.createNamedQuery("Movie.findAll", Movie.class).getResultList(); 
    }
    
    public Movie getMovie(String movieid)
    {
        return em.createNamedQuery("Movie.findByMovieid", Movie.class)
                .setParameter("movieid", movieid)
                .getSingleResult();
    }
    
    public List<Genre> getGenresForMovie(String movieid)
    {
        return em.createNamedQuery("Movie.findGenresByMovie", Genre.class)
                .setParameter("movieid", movieid)
                .getResultList();
    }
    
    public List<Showtime> getShowtimesForMovieForTheater(Movie movie, Theater theater)
    {
        return em.createNamedQuery("Showtime.findByMovieAndTheater", Showtime.class)
                .setParameter("movie", movie)
                .setParameter("theater", theater)
                .getResultList();
    }
    
    
}
