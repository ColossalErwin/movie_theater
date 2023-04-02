/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.movieEJB;
import entities.Location;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author hieutran
 */
@Named(value = "mainPageBean")
@SessionScoped
public class MainPageBean implements Serializable {
    @EJB
    private movieEJB movieEJB;

    /**
     * Creates a new instance of MainPageBean
     */
    public MainPageBean() {
    }
    
    public List<Location> getLocationList()
    {
        return movieEJB.findAllLocations();
    }
    
}
