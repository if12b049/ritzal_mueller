package services;

import businessobjects.Book;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    }

    public List<Book> getAllBooks(){

        //MOK DAL
        List <Book> bookList = new ArrayList<Book>();

        Book b = new Book();

        b.setId(1);
        b.setISBN("123");
        b.setDescription("cooles Buch");
        b.setLanguage("deutsch");
        b.setPages(1337);
        b.setSubtitle("none");

        Book b1 = new Book();

        b1.setId(1);
        b1.setISBN("321");
        b1.setDescription("dummes Buch");
        b1.setLanguage("deutsch");
        b1.setPages(1234);
        b1.setSubtitle("Englisch");

        bookList.add(b);
        bookList.add(b1);

        return bookList;

        /*List bookList = new ArrayList<Book>();
        bookList = em.createNamedQuery("Books.selectAll").getResultList();

        return bookList;*/

    }

    public List<Book> getConcreteBooks(String title){
        List <Book> bookList = new ArrayList<Book>();

        Book b = new Book();

        b.setId(1);
        b.setISBN("123");
        b.setDescription(title);
        b.setLanguage("deutsch");
        b.setPages(1337);
        b.setSubtitle("none");

        bookList.add(b);

        return bookList;
    }

}
