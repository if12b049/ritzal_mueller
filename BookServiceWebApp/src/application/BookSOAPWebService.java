package application;

import businessobjects.Author;
import businessobjects.Book;
import businessobjects.Publisher;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.File;
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
    public List<Book> getConcreteBooks(String title);
    /*Author*/
    @WebMethod
    public List<Author> getAllAuthors();
    @WebMethod
    public List<Author> getConcreteAuthor(String name);
    @WebMethod
    public void createAuthor(String author);
    @WebMethod
    public void updateAuthor(String name);
    @WebMethod
    public void deleteAuthor(String name);
    /*Publisher*/
    @WebMethod
    public List<Publisher> getAllPublisher();
    @WebMethod
    public List<Publisher> getConcretePublisher(String name);
    @WebMethod
    public void createPublisher(String author);
    @WebMethod
    public void updatePublisher(String name);
    @WebMethod
    public void deletePublisher(String name);

}