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
import entities.Location;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author hieutran
 */
@Named(value = "showLocationBean")
@SessionScoped
public class ShowLocationBean implements Serializable {

    @EJB
    private movieEJB movieEJB;
    private Location location;
    /**
     * Creates a new instance of ShowTheaterBean
     */
    public ShowLocationBean() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String showLocation(Location location) {
        this.location = location;
        return "ShowLocation.xhtml" + "?faces-redirect=true";
    }
    
    public String backToLocation() {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String zipcode =  params.get("zipcode"); 
      location = movieEJB.getLocation(zipcode);
      return "ShowLocation.xhtml" + "?faces-redirect=true";
    }
    
    public String showTheatersForLocation() {
        
    
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String zipcode =  params.get("zipcode"); 
      location = movieEJB.getLocation(zipcode);
      
      return "Theaters.xhtml" + "?faces-redirect=true";
    }
    
    public List<Theater> getTheaterList()
    {
        if (location != null)
           return movieEJB.getTheatersForLocation(location.getZipcode());
        else
           return null;
    }  
}
