package com.bookserviceapp.resources;

import com.bookserviceapp.businessobjects.Author;
import com.bookserviceapp.businessobjects.Publisher;
import com.bookserviceapp.services.AuthorService;
import com.bookserviceapp.services.PublisherService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by phips on 05.12.2014.
 */
@Path("/publisher")
public class PublisherResource {
    @PersistenceContext
    EntityManager em;

    private Publisher publisher;
    @Inject
    PublisherService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publisher> getAllPublishers() {
        return service.getAllPublishers();
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publisher> getPublisherByName(@PathParam("name") String name) {
        return service.getPublisherByName(name);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publisher> getPublisherById(@PathParam("id") int id) {
        return service.getPublisherById(id);
    }


    //@PUT
    //@DELETE
    //@POST

}
