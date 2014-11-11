package services;

import businessobjects.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.List;

/**
 * Created by Roman on 04.11.2014.
 */

@Path("/book")
public class BookResource {
    @PersistenceContext
    EntityManager em;

    private Book book;

    private BookService service;

    @GET
    @Path("/xml/{title}")
    @Produces(MediaType.TEXT_XML)

    public Book searchConcreteBook(@PathParam("title")String title) {
        book.setISBN(title);
        System.out.println("ISBN " + book.getISBN());
        return service.searchConcreteBook(title);
    }

    @GET
    @Path("/xml")
    //@Produces(MediaType.TEXT_XML)
    @Produces("application/xml")

    public List<Book> searchBook() {
        return service.searchBook();
    }
}
