package application;

import businessobjects.*;
import services.BookService;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */

@WebService(endpointInterface = "application.BookSOAPWebService")
public class BookSOAPWebServiceImpl implements BookSOAPWebService{
    @Inject
    private BookService bookService;

    @Override
    public void importBook(Book book) {
            bookService.importBook(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Override
    public List<Book> getConcreteBooks(String title) {
        return bookService.getConcreteBooks(title);
    }

    @Override
    public List<Author> getAllAuthors() {
        return null;
    }

    @Override
    public List<Author> getConcreteAuthor(String name) {
        return null;
    }

    @Override
    public void createAuthor(String author) {

    }

    @Override
    public void updateAuthor(String name) {

    }

    @Override
    public void deleteAuthor(String name) {

    }

    @Override
    public List<Publisher> getAllPublisher() {
        return null;
    }

    @Override
    public List<Publisher> getConcretePublisher(String name) {
        return null;
    }

    @Override
    public void createPublisher(String author) {

    }

    @Override
    public void updatePublisher(String name) {

    }

    @Override
    public void deletePublisher(String name) {

    }

}
