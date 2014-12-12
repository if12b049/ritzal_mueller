package com.bookserviceapp.services;

import com.bookserviceapp.businessobjects.Book;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Roman on 04.11.2014.
 */

@Stateless
@LocalBean

public class BookService {
    @PersistenceContext
    private EntityManager em;

    public void importBook(Book b) {
        em.persist(b);
    }

    public List<Book> getAllBooks(){
        return em.createNamedQuery("Book.selectAll").getResultList();
    }

    public List<Book> getBookByTitle(String title){
        return em.createNamedQuery("Book.selectByTitle").setParameter("title", title).getResultList();
    }

    public List<Book> getBookById(int id){
        return em.createNamedQuery("Book.selectById").setParameter("id", id).getResultList();
    }
}
