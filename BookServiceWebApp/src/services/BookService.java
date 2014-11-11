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

    public List<Book> searchBook(){
        List <Book> bookList = new ArrayList<Book>();

        Book b = new Book();

        b.setId(1);
        b.setISBN("123");
        b.setDescription("cooles Buch");
        b.setLanguage("deutsch");
        b.setPages(1337);
        b.setSubtitle("none");

        bookList.add(b);

        return bookList;
    }

    public Book searchConcreteBook(String title){
        Book b = new Book();
        b.setISBN("Game of Thrones");
        return b;
    }

}
