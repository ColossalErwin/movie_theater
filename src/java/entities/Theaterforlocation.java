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
@Table(name = "THEATERFORLOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theaterforlocation.findAll", query = "SELECT t FROM Theaterforlocation t"),
    @NamedQuery(name = "Theaterforlocation.findByTheaterid", query = "SELECT t FROM Theaterforlocation t WHERE t.theaterforlocationPK.theaterid = :theaterid"),
    @NamedQuery(name = "Theaterforlocation.findByZipcode", query = "SELECT t FROM Theaterforlocation t WHERE t.theaterforlocationPK.zipcode = :zipcode")})
public class Theaterforlocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TheaterforlocationPK theaterforlocationPK;

    public Theaterforlocation() {
    }

    public Theaterforlocation(TheaterforlocationPK theaterforlocationPK) {
        this.theaterforlocationPK = theaterforlocationPK;
    }

    public Theaterforlocation(String theaterid, String zipcode) {
        this.theaterforlocationPK = new TheaterforlocationPK(theaterid, zipcode);
    }

    public TheaterforlocationPK getTheaterforlocationPK() {
        return theaterforlocationPK;
    }

    public void setTheaterforlocationPK(TheaterforlocationPK theaterforlocationPK) {
        this.theaterforlocationPK = theaterforlocationPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterforlocationPK != null ? theaterforlocationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theaterforlocation)) {
            return false;
        }
        Theaterforlocation other = (Theaterforlocation) object;
        if ((this.theaterforlocationPK == null && other.theaterforlocationPK != null) || (this.theaterforlocationPK != null && !this.theaterforlocationPK.equals(other.theaterforlocationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theaterforlocation[ theaterforlocationPK=" + theaterforlocationPK + " ]";
    }
    
}
