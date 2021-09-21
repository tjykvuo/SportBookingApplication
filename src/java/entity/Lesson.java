/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author cmpdambr
 */
@Entity
@Table(name = "LESSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l")
    , @NamedQuery(name = "Lesson.findByLessonno", query = "SELECT l FROM Lesson l WHERE l.lessonno = :lessonno")
    , @NamedQuery(name = "Lesson.findByLessondate", query = "SELECT l FROM Lesson l WHERE l.lessondate = :lessondate")
    , @NamedQuery(name = "Lesson.findByStarttime", query = "SELECT l FROM Lesson l WHERE l.starttime = :starttime")
    , @NamedQuery(name = "Lesson.findByEndtime", query = "SELECT l FROM Lesson l WHERE l.endtime = :endtime")
    , @NamedQuery(name = "Lesson.findByPrice", query = "SELECT l FROM Lesson l WHERE l.price = :price")
    , @NamedQuery(name = "Lesson.findByAvailablespaces", query = "SELECT l FROM Lesson l WHERE l.availablespaces = :availablespaces")})
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LESSONNO")
    private Integer lessonno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LESSONDATE")
    private int lessondate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTTIME")
    private int starttime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENDTIME")
    private int endtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Column(name = "AVAILABLESPACES")
    private Integer availablespaces;
    @JoinColumn(name = "INSTRUCTORNO", referencedColumnName = "INSTRUCTORNO")
    @ManyToOne(optional = false)
    private Instructor instructorno;
    @JoinColumn(name = "SPORTNO", referencedColumnName = "SPORTNO")
    @ManyToOne(optional = false)
    private Sport sportno;
    @OneToMany(mappedBy = "lessonno")
    private Collection<Booking> bookingCollection;

    public Lesson() {
    }

    public Lesson(Integer lessonno) {
        this.lessonno = lessonno;
    }

    public Lesson(Integer lessonno, int lessondate, int starttime, int endtime, int price) {
        this.lessonno = lessonno;
        this.lessondate = lessondate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.price = price;
    }

    public Integer getLessonno() {
        return lessonno;
    }

    public void setLessonno(Integer lessonno) {
        this.lessonno = lessonno;
    }

    public int getLessondate() {
        return lessondate;
    }

    public void setLessondate(int lessondate) {
        this.lessondate = lessondate;
    }

    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public int getEndtime() {
        return endtime;
    }

    public void setEndtime(int endtime) {
        this.endtime = endtime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getAvailablespaces() {
        return availablespaces;
    }

    public void setAvailablespaces(Integer availablespaces) {
        this.availablespaces = availablespaces;
    }

    public Instructor getInstructorno() {
        return instructorno;
    }

    public void setInstructorno(Instructor instructorno) {
        this.instructorno = instructorno;
    }

    public Sport getSportno() {
        return sportno;
    }

    public void setSportno(Sport sportno) {
        this.sportno = sportno;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonno != null ? lessonno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.lessonno == null && other.lessonno != null) || (this.lessonno != null && !this.lessonno.equals(other.lessonno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lesson[ lessonno=" + lessonno + " ]";
    }
    
}
