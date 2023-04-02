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
@Table(name = "THEATER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t"),
    @NamedQuery(name = "Theater.findByTheaterid", query = "SELECT t FROM Theater t WHERE t.theaterid = :theaterid"),
    @NamedQuery(name = "Theater.findByName", query = "SELECT t FROM Theater t WHERE t.name = :name"),
    @NamedQuery(name = "Theater.findByPhone", query = "SELECT t FROM Theater t WHERE t.phone = :phone"),
    @NamedQuery(name = "Theater.findByStreet", query = "SELECT t FROM Theater t WHERE t.street = :street"),
    @NamedQuery(name = "Theater.findMoviesByTheater", query = "SELECT m FROM Movie m, Moviefortheater mo WHERE m.movieid = mo.moviefortheaterPK.movieid and mo.moviefortheaterPK.theaterid = :theaterid")})
public class Theater implements Serializable {

    @Size(max = 25)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 10)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 200)
    @Column(name = "STREET")
    private String street;
    @Size(max = 500)
    @Column(name = "IMAGEURL")
    private String imageurl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theaterid")
    private Collection<Showtime> showtimeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "THEATERID")
    private String theaterid;

    public Theater() {
    }

    public Theater(String theaterid) {
        this.theaterid = theaterid;
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
        hash += (theaterid != null ? theaterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.theaterid == null && other.theaterid != null) || (this.theaterid != null && !this.theaterid.equals(other.theaterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theater[ theaterid=" + theaterid + " ]";
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    
}
