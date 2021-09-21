/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author cmpdambr
 */
@Entity
@Table(name = "SPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sport.findAll", query = "SELECT s FROM Sport s")
    , @NamedQuery(name = "Sport.findBySportno", query = "SELECT s FROM Sport s WHERE s.sportno = :sportno")
    , @NamedQuery(name = "Sport.findBySportname", query = "SELECT s FROM Sport s WHERE s.sportname = :sportname")
    , @NamedQuery(name = "Sport.findByIndoor", query = "SELECT s FROM Sport s WHERE s.indoor = :indoor")})
public class Sport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPORTNO")
    private Integer sportno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SPORTNAME")
    private String sportname;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 32700)
    @Column(name = "SPORTDESCRIPTION")
    private String sportdescription;
    @Column(name = "INDOOR")
    private Boolean indoor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sportno")
    private Collection<Lesson> lessonCollection;

    public Sport() {
    }

    public Sport(Integer sportno) {
        this.sportno = sportno;
    }

    public Sport(Integer sportno, String sportname, String sportdescription) {
        this.sportno = sportno;
        this.sportname = sportname;
        this.sportdescription = sportdescription;
    }

    public Integer getSportno() {
        return sportno;
    }

    public void setSportno(Integer sportno) {
        this.sportno = sportno;
    }

    public String getSportname() {
        return sportname;
    }

    public void setSportname(String sportname) {
        this.sportname = sportname;
    }

    public String getSportdescription() {
        return sportdescription;
    }

    public void setSportdescription(String sportdescription) {
        this.sportdescription = sportdescription;
    }

    public Boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
    }

    @XmlTransient
    public Collection<Lesson> getLessonCollection() {
        return lessonCollection;
    }

    public void setLessonCollection(Collection<Lesson> lessonCollection) {
        this.lessonCollection = lessonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sportno != null ? sportno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sport)) {
            return false;
        }
        Sport other = (Sport) object;
        if ((this.sportno == null && other.sportno != null) || (this.sportno != null && !this.sportno.equals(other.sportno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sport[ sportno=" + sportno + " ]";
    }
    
}
