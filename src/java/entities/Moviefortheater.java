/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hieutran
 */
@Entity
@Table(name = "MOVIEFORTHEATER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moviefortheater.findAll", query = "SELECT m FROM Moviefortheater m"),
    @NamedQuery(name = "Moviefortheater.findByMovieid", query = "SELECT m FROM Moviefortheater m WHERE m.moviefortheaterPK.movieid = :movieid"),
    @NamedQuery(name = "Moviefortheater.findByTheaterid", query = "SELECT m FROM Moviefortheater m WHERE m.moviefortheaterPK.theaterid = :theaterid"),
    @NamedQuery(name = "Moviefortheater.findShowtimeByTheateridAndMovieid", query = "SELECT s FROM Showtime s WHERE s.movieid = :movieid and s.theaterid = :theaterid")})
public class Moviefortheater implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MoviefortheaterPK moviefortheaterPK;

    public Moviefortheater() {
    }

    public Moviefortheater(MoviefortheaterPK moviefortheaterPK) {
        this.moviefortheaterPK = moviefortheaterPK;
    }

    public Moviefortheater(String movieid, String theaterid) {
        this.moviefortheaterPK = new MoviefortheaterPK(movieid, theaterid);
    }

    public MoviefortheaterPK getMoviefortheaterPK() {
        return moviefortheaterPK;
    }

    public void setMoviefortheaterPK(MoviefortheaterPK moviefortheaterPK) {
        this.moviefortheaterPK = moviefortheaterPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviefortheaterPK != null ? moviefortheaterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviefortheater)) {
            return false;
        }
        Moviefortheater other = (Moviefortheater) object;
        if ((this.moviefortheaterPK == null && other.moviefortheaterPK != null) || (this.moviefortheaterPK != null && !this.moviefortheaterPK.equals(other.moviefortheaterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Moviefortheater[ moviefortheaterPK=" + moviefortheaterPK + " ]";
    }
    
}
