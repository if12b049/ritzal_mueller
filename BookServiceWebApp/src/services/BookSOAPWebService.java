package services;

import businessobjects.Book;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.File;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
@WebService
public interface BookSOAPWebService {
    @WebMethod
    public void importBook(Book book);
    @WebMethod
    public List<Book> searchBook();
    @WebMethod
    public Book searchConcreteBook(String title);
}