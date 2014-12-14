package com.bookserviceapp.application;

import com.bookserviceapp.businessobjects.Book;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
@WebService
public interface BookSOAPWebService {
    /*Book*/
    @WebMethod
    public void importBook(Book book);
    @WebMethod
    public List<Book> getAllBooks();
    @WebMethod
    public List<Book> getBookByTitle(String title);

}