package com.bookserviceapp.resources;

import com.bookserviceapp.businessobjects.Author;
import com.bookserviceapp.businessobjects.Publisher;
import com.bookserviceapp.services.AuthorService;
import com.bookserviceapp.services.PublisherService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
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

    /*** Create ***/
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPublisher(List<Publisher> listPub){
        for(Publisher tmp : listPub) service.createPublisher(tmp);

    }


    /*** Read ***/
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

    /*** Update ***/
    @PUT
    @Consumes({"application/json"})
    public void updatePublisher(List <Publisher> listPub){
        for(Publisher tmp : listPub) service.updatePublisher(tmp);
    }

    /*** Delete ***/
    @DELETE
    @Consumes("text/plain")
    public void deletePublisherPerId(String input){
        //java.lang.IllegalArgumentException: com.bookserviceapp.businessobjects.Publisher cannot be cast to java.io.Serializable
        int id = Integer.parseInt(input);
        service.removePublisher(new Publisher(id));
    }

    @DELETE
    @Consumes({"application/json"})
    public void deletePublisherPerObject(Publisher publisher){
        //java.lang.IllegalArgumentException: com.bookserviceapp.businessobjects.Publisher cannot be cast to java.io.Serializable

        service.removePublisher(publisher);
    }


}
