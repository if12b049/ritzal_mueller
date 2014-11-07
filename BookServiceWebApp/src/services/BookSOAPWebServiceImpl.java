package services;

import businessobjects.*;

import javax.jws.WebService;

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
    public Book searchBook(String title) {return bookService.searchBook(title); }
}
