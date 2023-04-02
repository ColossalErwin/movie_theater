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
public class GenreformoviePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "GENREID")
    private String genreid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "MOVIEID")
    private String movieid;

    public GenreformoviePK() {
    }

    public GenreformoviePK(String genreid, String movieid) {
        this.genreid = genreid;
        this.movieid = movieid;
    }

    public String getGenreid() {
        return genreid;
    }

    public void setGenreid(String genreid) {
        this.genreid = genreid;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genreid != null ? genreid.hashCode() : 0);
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenreformoviePK)) {
            return false;
        }
        GenreformoviePK other = (GenreformoviePK) object;
        if ((this.genreid == null && other.genreid != null) || (this.genreid != null && !this.genreid.equals(other.genreid))) {
            return false;
        }
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GenreformoviePK[ genreid=" + genreid + ", movieid=" + movieid + " ]";
    }
    
}
