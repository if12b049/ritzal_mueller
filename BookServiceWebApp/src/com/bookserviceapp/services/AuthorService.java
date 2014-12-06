package com.bookserviceapp.services;

import com.bookserviceapp.businessobjects.Author;
import com.bookserviceapp.businessobjects.Book;

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



    public void importAuthor(Author a) {
        em.persist(a);
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
