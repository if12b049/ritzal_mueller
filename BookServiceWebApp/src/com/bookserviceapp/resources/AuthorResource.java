package com.bookserviceapp.resources;

import com.bookserviceapp.businessobjects.Author;
import com.bookserviceapp.businessobjects.Book;
import com.bookserviceapp.businessobjects.Publisher;
import com.bookserviceapp.services.AuthorService;
import com.bookserviceapp.services.BookService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by phips on 05.12.2014.
 */

@Path("/author")
public class AuthorResource {

    @PersistenceContext
    EntityManager em;

    private Author author;
    @Inject
    AuthorService service;

    /*** Create ***/
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPublisher(List<Author> listAuthor){
        for(Author tmp : listAuthor) service.createAuthor(tmp);
    }

    /*** Read ***/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAllAuthors() {
        return service.getAllAuthors();
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthorByName(@PathParam("name") String name) {
        return service.getAuthorByName(name);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthorById(@PathParam("id") int id) {
        return service.getAuthorById(id);
    }


    /*** Update ***/
    @PUT
    @Consumes({"application/json"})
    @Path("/{id}")
    public void updatePublisher(List <Author> listAuthor, @PathParam("id") int id){
        for(Author tmp : listAuthor) service.updateAuthor(tmp, id);
    }
    /*** Delete ***/
    @DELETE
    @Consumes("text/plain")
    public void deletePublisherPerId(String input){
        int id = Integer.parseInt(input);
        service.removeAuthor(id);
    }
    //@POST
}
