package services;

import businessobjects.Book;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.ArrayList;
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
        return em.createNamedQuery("Books.selectAll").getResultList();
    }

    public List<Book> getBookByTitle(String title){
        return em.createNamedQuery("Books.selectByTitle").setParameter("title", title).getResultList();
    }

}
