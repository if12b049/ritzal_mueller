package com.bookserviceapp.services;

import com.bookserviceapp.businessobjects.Publisher;
import org.jboss.annotation.security.SecurityDomain;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.annotation.ServletSecurity;
import java.util.List;

/**
 * Created by Roman on 04.11.2014.
 */

@Stateless
@LocalBean
@SecurityDomain("BookServiceSD")
public class PublisherService {
    @PersistenceContext
    private EntityManager em;

    @RolesAllowed({"BSRead","BSWrite"})
    public List<Publisher> getAllPublishers(){
        return em.createNamedQuery("Publisher.selectAll").getResultList();
    }

    @RolesAllowed({"BSRead","BSWrite"})
    public List<Publisher> getPublisherByName(String name){
        return em.createNamedQuery("Publisher.selectByName").setParameter("name", name).getResultList();
    }

    @RolesAllowed({"BSRead","BSWrite"})
    public Publisher getPublisherById(int id){
        return (Publisher) em.createNamedQuery("Publisher.selectById").setParameter("id", id).getSingleResult();
    }

    @RolesAllowed({"BSWrite"})
    public void removePublisher(int id){

        Publisher publisher = em.find(Publisher.class, id); //Object!

        if(publisher != null) {
            //       em.getTransaction().begin();
            em.remove(publisher);
            //        em.getTransaction().commit();
        }
    }

    @RolesAllowed({"BSWrite"})
    public void createPublisher(Publisher publisher){
      //  em.getTransaction().begin();
        em.persist(publisher);
      //  em.getTransaction().commit();
    }

    @RolesAllowed({"BSWrite"})
    public void updatePublisher(Publisher p, int id){
        Publisher publisher = em.find(Publisher.class, id);

    //    em.getTransaction().begin();
        if(publisher != null) {
            publisher = p;
            publisher.setId(id);
            em.merge(publisher);
        }
       // else em.persist(p);
   //     em.getTransaction().commit();
    }

}

