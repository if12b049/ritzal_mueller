package services;

import businessobjects.*;

import javax.jws.WebService;
import java.io.File;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */

@WebService(endpointInterface = "services.BookSOAPWebService",
        serviceName="BookSOAPWebService")
public class BookSOAPWebServiceImpl implements BookSOAPWebService{
    private BookService bookService;

    @Override
    public void importBook(Book book) {bookService.importBook(book);  }

    @Override
    public List<Book> searchBook() {
        return bookService.searchBook();
    }

    @Override
    public Book searchConcreteBook(String title) {
        return bookService.searchConcreteBook(title);
    }

}
