package services;

import businessobjects.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

/**
 * Created by Roman on 04.11.2014.
 */

@Path("/book")

public class BookResource {

    private Book book;

    @GET
    @Path("/{parameter}")
    //@Produces(MediaType.TEXT_PLAIN)

    public void importBook(@PathParam("parameter")String title){
        System.out.println("TITEL: " + title);
    }

}
