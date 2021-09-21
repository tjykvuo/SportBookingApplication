/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Instructor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cmpdambr
 */
@Named(value = "instructorBean")
@SessionScoped
public class InstructorBean implements Serializable {

    @PersistenceContext(unitName = "SportBookingApplicationPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of InstructorBean
     */
    public InstructorBean() {
    }

    public List<Instructor> getInstructorList() {
        return em.createNamedQuery("Instructor.findAll").getResultList();
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
