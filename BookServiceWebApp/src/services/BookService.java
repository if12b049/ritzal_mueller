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

    public void importBook(Book b) {}

    public List<Book> getAllBooks(){
        return em.createNamedQuery("Books.selectAll").getResultList();
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
