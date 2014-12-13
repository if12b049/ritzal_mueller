package com.bookserviceapp.resources;

import com.bookserviceapp.businessobjects.Book;
import com.bookserviceapp.services.BookService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Roman on 04.11.2014.
 */

@Path("/book")
public class BookResource {
    @PersistenceContext
    EntityManager em;

    private Book book;
    @Inject
    BookService service;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GET
    @Path("/title/{title}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getBookByTitle(@PathParam("title") String title) {
        return service.getBookByTitle(title);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getBookById(@PathParam("id") int id) {
        return service.getBookById(id);
    }
}
