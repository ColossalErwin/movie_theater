/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hieutran
 */
@Entity
@Table(name = "SHOWTIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Showtime.findAll", query = "SELECT s FROM Showtime s"),
    @NamedQuery(name = "Showtime.findByTimeid", query = "SELECT s FROM Showtime s WHERE s.timeid = :timeid"),
    @NamedQuery(name = "Showtime.findByShowtime", query = "SELECT s FROM Showtime s WHERE s.showtime = :showtime"),
    @NamedQuery(name = "Showtime.findByMovieAndTheater", 
            query = "SELECT s FROM Showtime s WHERE s.movieid = :movie and s.theaterid = :theater")})
public class Showtime implements Serializable {

    @Size(max = 5)
    @Column(name = "SHOWTIME")
    private String showtime;
    @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID")
    @ManyToOne(optional = false)
    private Movie movieid;
    @JoinColumn(name = "THEATERID", referencedColumnName = "THEATERID")
    @ManyToOne(optional = false)
    private Theater theaterid;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TIMEID")
    private String timeid;

    public Showtime() {
    }

    public Showtime(String timeid) {
        this.timeid = timeid;
    }

    public String getTimeid() {
        return timeid;
    }

    public void setTimeid(String timeid) {
        this.timeid = timeid;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeid != null ? timeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Showtime)) {
            return false;
        }
        Showtime other = (Showtime) object;
        if ((this.timeid == null && other.timeid != null) || (this.timeid != null && !this.timeid.equals(other.timeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Showtime[ timeid=" + timeid + " ]";
    }


    public Movie getMovieid() {
        return movieid;
    }

    public void setMovieid(Movie movieid) {
        this.movieid = movieid;
    }

    public Theater getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(Theater theaterid) {
        this.theaterid = theaterid;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }
    
}
