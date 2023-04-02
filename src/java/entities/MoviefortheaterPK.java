/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hieutran
 */
@Embeddable
public class MoviefortheaterPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "MOVIEID")
    private String movieid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "THEATERID")
    private String theaterid;

    public MoviefortheaterPK() {
    }

    public MoviefortheaterPK(String movieid, String theaterid) {
        this.movieid = movieid;
        this.theaterid = theaterid;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(String theaterid) {
        this.theaterid = theaterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        hash += (theaterid != null ? theaterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoviefortheaterPK)) {
            return false;
        }
        MoviefortheaterPK other = (MoviefortheaterPK) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        if ((this.theaterid == null && other.theaterid != null) || (this.theaterid != null && !this.theaterid.equals(other.theaterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MoviefortheaterPK[ movieid=" + movieid + ", theaterid=" + theaterid + " ]";
    }
    
}
