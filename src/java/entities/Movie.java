/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hieutran
 */
@Entity
@Table(name = "MOVIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieid", query = "SELECT m FROM Movie m WHERE m.movieid = :movieid"),
    @NamedQuery(name = "Movie.findByName", query = "SELECT m FROM Movie m WHERE m.name = :name"),
    @NamedQuery(name = "Movie.findByDescription", query = "SELECT m FROM Movie m WHERE m.description = :description"),
    @NamedQuery(name = "Movie.findByDuration", query = "SELECT m FROM Movie m WHERE m.duration = :duration"),
    @NamedQuery(name = "Movie.findGenresByMovie", query = "SELECT g FROM Genre g, Genreformovie ge WHERE g.genreid = ge.genreformoviePK.genreid "
            + "and ge.genreformoviePK.movieid = :movieid"),
})
public class Movie implements Serializable {

    @Size(max = 150)
    @Column(name = "NAME")
    private String name;
    @Size(max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 6)
    @Column(name = "DURATION")
    private String duration;
    @Size(max = 500)
    @Column(name = "IMAGEURL")
    private String imageurl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieid")
    private Collection<Showtime> showtimeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "MOVIEID")
    private String movieid;

    public Movie() {
    }

    public Movie(String movieid) {
        this.movieid = movieid;
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
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movie[ movieid=" + movieid + " ]";
    }
    @XmlTransient
    public Collection<Showtime> getShowtimeCollection() {
        return showtimeCollection;
    }
    public void setShowtimeCollection(Collection<Showtime> showtimeCollection) {
        this.showtimeCollection = showtimeCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    
}
