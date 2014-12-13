package com.bookserviceapp.services;

import com.bookserviceapp.businessobjects.Author;
import com.bookserviceapp.businessobjects.Book;
import com.bookserviceapp.businessobjects.Publisher;

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
        List<Author> authorList = em.createNamedQuery("Author.selectAll").getResultList();
        List<Publisher> publisherList = em.createNamedQuery("Publisher.selectAll").getResultList();

        List<Author> localAuthors = b.getAuthorList();

        for(int j=0; j<b.getAuthorList().size(); j++){
            for(int i=0; i<authorList.size(); i++){

                if(authorList.get(i).getFirstname() ==){

                }
            }
        }




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
