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
