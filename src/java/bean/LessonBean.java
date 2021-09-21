/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Lesson;
import entity.Sport;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cmpdambr
 */
@Named(value = "lessonBean")
@SessionScoped
public class LessonBean implements Serializable {

    @PersistenceContext(unitName = "SportBookingApplicationPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of LessonBean
     */
    public LessonBean() {
    }

    public List<Lesson> getLessonList() {
        return em.createNamedQuery("Lesson.findAll").getResultList();
    }

    public List<Sport> getSportRecord() {
        return em.createNamedQuery("Sport.findAll").getResultList();
    }

    public void setAvailableSpaces(Lesson lesson) throws IOException {
        int spaces = lesson.getAvailablespaces();
        lesson.setAvailablespaces(spaces - 1);
        updateEntity(lesson);
        
        FacesContext fContext = FacesContext.getCurrentInstance();
        ExternalContext extContext = fContext.getExternalContext();
        extContext.redirect("http://localhost:8080/SportBookingApplication/faces/FinalBookingForm.xhtml");
    }

    public class BookingConfirmMovement implements Serializable {
        public String redirect(Lesson lesson) {
            return "FinalBookingForm.xhtml";
        }
    }

    public void updateEntity(Object object) {
        try {
            utx.begin();
            em.merge(object);
            utx.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
