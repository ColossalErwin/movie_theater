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
@Table(name = "GENRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g"),
    @NamedQuery(name = "Genre.findByGenreid", query = "SELECT g FROM Genre g WHERE g.genreid = :genreid"),
    @NamedQuery(name = "Genre.findByName", query = "SELECT g FROM Genre g WHERE g.name = :name")})
public class Genre implements Serializable {

    @Size(max = 20)
    @Column(name = "NAME")
    private String name;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "GENREID")
    private String genreid;

    public Genre() {
    }

    public Genre(String genreid) {
        this.genreid = genreid;
    }

    public String getGenreid() {
        return genreid;
    }

    public void setGenreid(String genreid) {
        this.genreid = genreid;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genreid != null ? genreid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.genreid == null && other.genreid != null) || (this.genreid != null && !this.genreid.equals(other.genreid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Genre[ genreid=" + genreid + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
