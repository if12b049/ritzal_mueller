package com.bookserviceapp.services;

import com.bookserviceapp.businessobjects.Author;
import com.bookserviceapp.businessobjects.Publisher;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Roman on 04.11.2014.
 */

@Stateless
@LocalBean

public class PublisherService {
    @PersistenceContext
    private EntityManager em;

    public List<Publisher> getAllPublishers(){
        return em.createNamedQuery("Publisher.selectAll").getResultList();
    }

    public List<Publisher> getPublisherByName(String name){
        return em.createNamedQuery("Publisher.selectByName").setParameter("name", name).getResultList();
    }

    public Publisher getPublisherById(int id){
        return (Publisher) em.createNamedQuery("Publisher.selectById").setParameter("id", id).getSingleResult();
    }

    public void removePublisher(int id){

        Publisher publisher = em.find(Publisher.class, id); //Object!

        if(publisher != null) {
            //       em.getTransaction().begin();
            em.remove(publisher);
            //        em.getTransaction().commit();
        }
    }
    public void createPublisher(Publisher publisher){
      //  em.getTransaction().begin();
        em.persist(publisher);
      //  em.getTransaction().commit();
    }

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

