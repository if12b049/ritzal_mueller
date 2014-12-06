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

    public void importPublisher(Publisher p) {
        em.persist(p);
    }

    public List<Publisher> getAllPublishers(){
        return em.createNamedQuery("Publisher.selectAll").getResultList();
    }

    public List<Publisher> getPublisherByName(String name){
        return em.createNamedQuery("Publisher.selectByName").setParameter("name", name).getResultList();
    }

    public List<Publisher> getPublisherById(int id){
        return em.createNamedQuery("Publisher.selectById").setParameter("id", id).getResultList();
    }


}
