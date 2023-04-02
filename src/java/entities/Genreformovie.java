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
@Table(name = "GENREFORMOVIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genreformovie.findAll", query = "SELECT g FROM Genreformovie g"),
    @NamedQuery(name = "Genreformovie.findByGenreid", query = "SELECT g FROM Genreformovie g WHERE g.genreformoviePK.genreid = :genreid"),
    @NamedQuery(name = "Genreformovie.findByMovieid", query = "SELECT g FROM Genreformovie g WHERE g.genreformoviePK.movieid = :movieid")})
public class Genreformovie implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GenreformoviePK genreformoviePK;

    public Genreformovie() {
    }

    public Genreformovie(GenreformoviePK genreformoviePK) {
        this.genreformoviePK = genreformoviePK;
    }

    public Genreformovie(String genreid, String movieid) {
        this.genreformoviePK = new GenreformoviePK(genreid, movieid);
    }

    public GenreformoviePK getGenreformoviePK() {
        return genreformoviePK;
    }

    public void setGenreformoviePK(GenreformoviePK genreformoviePK) {
        this.genreformoviePK = genreformoviePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genreformoviePK != null ? genreformoviePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genreformovie)) {
            return false;
        }
        Genreformovie other = (Genreformovie) object;
        if ((this.genreformoviePK == null && other.genreformoviePK != null) || (this.genreformoviePK != null && !this.genreformoviePK.equals(other.genreformoviePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Genreformovie[ genreformoviePK=" + genreformoviePK + " ]";
    }
    
}
