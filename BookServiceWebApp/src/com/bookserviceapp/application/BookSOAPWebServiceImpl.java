package com.bookserviceapp.application;

import com.bookserviceapp.businessobjects.*;
import com.bookserviceapp.services.BookService;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */

@WebService(endpointInterface = "com.bookserviceapp.application.BookSOAPWebService")
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
    public List<Book> getBookByTitle(String title) {
        return bookService.getBookByTitle(title);
    }

}
