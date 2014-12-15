package com.bookserviceapp.services;

import com.bookserviceapp.businessobjects.Author;
import com.bookserviceapp.businessobjects.Book;
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

public class AuthorService {
    @PersistenceContext
    private EntityManager em;

    public void createAuthor(Author author){
        //  em.getTransaction().begin();
        em.persist(author);
        //  em.getTransaction().commit();
    }
    public void removeAuthor(int id){

        Author author = em.find(Author.class, id); //Object!

        if(author != null) {
            //       em.getTransaction().begin();
            em.remove(author);
            //        em.getTransaction().commit();
        }
    }
    public List<Author> getAllAuthors(){
        return em.createNamedQuery("Author.selectAll").getResultList();
    }

    public List<Author> getAuthorByName(String name){
        return em.createNamedQuery("Author.selectByName").setParameter("name", name).getResultList();
    }

    public List<Author> getAuthorById(int id){
        return em.createNamedQuery("Author.selectById").setParameter("id", id).getResultList();
    }


}
