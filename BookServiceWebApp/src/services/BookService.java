package services;

import businessobjects.Book;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by Roman on 04.11.2014.
 */

@Stateless
@LocalBean

public class BookService {

    public void importBook(Book b) {
    }

    public Book searchBook(String title){
        return null;
    }

}
