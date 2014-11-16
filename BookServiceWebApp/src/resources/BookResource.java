package resources;

import businessobjects.Book;
import services.BookService;

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

    BookService service = new BookService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GET
    @Path("/{title}")
    @Produces(MediaType.TEXT_XML)
    public List<Book> getConcreteBooks(@PathParam("title") String title) {
        return service.getConcreteBooks(title);
    }


}
