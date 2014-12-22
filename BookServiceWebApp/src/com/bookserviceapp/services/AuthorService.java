package com.bookserviceapp.services;

import com.bookserviceapp.businessobjects.Author;
import com.bookserviceapp.businessobjects.Book;
import com.bookserviceapp.businessobjects.Publisher;
import org.jboss.annotation.security.SecurityDomain;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Roman on 04.11.2014.
 */

@Stateless
@LocalBean
@SecurityDomain("BookServiceSD")
public class AuthorService {
    @PersistenceContext
    private EntityManager em;

    @RolesAllowed({"BSWrite"})
    public void createAuthor(Author author){
        //  em.getTransaction().begin();
        em.persist(author);
        //  em.getTransaction().commit();
    }

    @RolesAllowed({"BSWrite"})
    public void removeAuthor(int id){

        Author author = em.find(Author.class, id); //Object!

        if(author != null) {
            //       em.getTransaction().begin();
            em.remove(author);
            //        em.getTransaction().commit();
        }
    }

    @RolesAllowed({"BSRead","BSWrite"})
    public List<Author> getAllAuthors(){
        return em.createNamedQuery("Author.selectAll").getResultList();
    }

    @RolesAllowed({"BSRead","BSWrite"})
    public List<Author> getAuthorByName(String name){
        return em.createNamedQuery("Author.selectByName").setParameter("name", name).getResultList();
    }

    @RolesAllowed({"BSRead","BSWrite"})
    public Author getAuthorById(int id){
        return (Author)em.createNamedQuery("Author.selectById").setParameter("id", id).getSingleResult();
    }

    @RolesAllowed({"BSWrite"})
    public void updateAuthor(Author a, int id){
        Author author = em.find(Author.class, id);

        //    em.getTransaction().begin();
        if(author != null) {
            author = a;
            author.setId(id);
            em.merge(author);
        }
        // else em.persist(p);
        //     em.getTransaction().commit();
    }


}
