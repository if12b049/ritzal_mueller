package services;

import businessobjects.Book;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Roman on 21.10.2014.
 */
@WebService
public interface BookSOAPWebService {
    @WebMethod
    public void importBook(Book book);
    @WebMethod
    public Book searchBook(String title);
}