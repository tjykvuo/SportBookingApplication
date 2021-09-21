/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Booking;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cmpdambr
 */
@Named(value = "bookingBean")
@SessionScoped
public class BookingBean implements Serializable {

    @PersistenceContext(unitName = "SportBookingApplicationPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of BookingBean
     */
    public BookingBean() {
    }
    public List<Booking> getBookingList() {
        return em.createNamedQuery("Booking.findAll").getResultList();
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
