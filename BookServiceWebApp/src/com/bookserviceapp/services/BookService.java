package com.bookserviceapp.services;

import com.bookserviceapp.businessobjects.Author;
import com.bookserviceapp.businessobjects.Book;
import com.bookserviceapp.businessobjects.Publisher;
import com.bookserviceapp.exceptions.AuthorNotFoundException;
import com.bookserviceapp.exceptions.PublisherNotFoundException;
import org.jboss.annotation.security.SecurityDomain;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 04.11.2014.
 */

@Stateless
@LocalBean
@SecurityDomain("BookServiceSD") //falschef annotion (lib)
public class BookService {
    @PersistenceContext
    private EntityManager em;

    @RolesAllowed({"BSWrite"})
    public void importBook(Book b) {

        int authorFound = 0;
        int publisherFound = 0;

        List<Author> authorList = em.createNamedQuery("Author.selectAll").getResultList();
        List<Publisher> publisherList = em.createNamedQuery("Publisher.selectAll").getResultList();

        List<Author> localAuthors = b.getAuthorList();
        Publisher localPublisher = b.getPublisher();

        int storedPublisher = 0;
        int listLength = b.getAuthorList().size();
        List<Integer> storedAuthorsIds = new ArrayList<Integer>();

        boolean check = true;


        try {
            //Liefert 0 zurück wenn der Publisher nicht gefunden wurde
            //Liefert die ID des Publishers zurück
            publisherFound = checkPublisher(publisherList, localPublisher);

            if (publisherFound == 0) {
                check = false;
                throw new PublisherNotFoundException("Publisher " + localPublisher.getName() + " was not found");
            }
        } catch (PublisherNotFoundException e) {
            e.printStackTrace();
        }

        if (!check) {
            return;
        }

        try {
            for (int i = 0; i < localAuthors.size(); i++) {
                authorFound = checkAuthor(authorList, localAuthors.get(i));

                if (authorFound == 0) {
                    check = false;
                    throw new AuthorNotFoundException("Author " + localAuthors.get(i).getFirstname() +
                            " " + localAuthors.get(i).getLastname() + " was not found");
                }
            }
        } catch (AuthorNotFoundException e) {
            e.printStackTrace();
        }

        if (!check) {
            return;
        }

        for (int j = 0; j < listLength; j++) {
            for (int i = 0; i < authorList.size(); i++) {
                //if(b.getAuthorList().size() != listLength)break;
                if (b.getAuthorList().size() == 0) break;

                //Schauen ob der lokale Autor bereits in der DB vorhanden ist
                if (authorList.get(i).getFirstname().equals(localAuthors.get(j).getFirstname())
                        && authorList.get(i).getLastname().equals(localAuthors.get(j).getLastname())) {
                    //JA, er ist vorhanden
                    //INSERT in authorbooks
                    //bookid -> bleibt leer wird später eingefügt
                    //authorid -> wird gesetzt auf den Wert des bereits gespeicherten Autors

                    em.createNativeQuery("INSERT INTO authorsbooks (bookid,authorid)" +
                            "VALUES(?, ?)").setParameter(1, null).setParameter(2, authorList.get(i).getId()).executeUpdate();


                    List resultList = em.createNativeQuery("SELECT id FROM authorsbooks WHERE bookid IS NULL " +
                            "OR bookid = '' OR bookid = null").getResultList();

                    Integer.parseInt(resultList.get(0).toString());
                    storedAuthorsIds.add(Integer.parseInt(resultList.get(0).toString()));

                    //Aus der Liste den bereits vorhandenen löschen, weil er nicht mehr persistiert werden muss
                    b.getAuthorList().remove(j);
                    if (b.getAuthorList().size() == 0) break;
                }
            }
        }

        for (int i = 0; i < publisherList.size(); i++) {
            //Schauen ob Publisher bereits vorhanden
            if (publisherList.get(i).getName().equals(b.getPublisher().getName())) {
                //ID des bereits vorhandenen Publisher wird gespeichert
                storedPublisher = publisherList.get(i).getId();

                //Publisher wird gelöscht da er nicht mehr persistiert werden muss
                b.deletePublisher();
                break;
            }
        }

        em.persist(b);
        em.flush();

        long newBookId = b.getId();

        for (int i = 0; i < storedAuthorsIds.size(); i++) {
            //Nachträgliches eintragen der bookid in der auhtorsbook Tabelle
            em.createNativeQuery("UPDATE authorsbooks SET bookid = ? WHERE id = ?") //WHERE bookid = NULL OR bookid = ''
                    .setParameter(1, newBookId).setParameter(2, storedAuthorsIds.get(i)).executeUpdate();
        }

        //Falls der Publisher gespeichert war -> Referenz auf den Publisher
        if (storedPublisher != 0) {
            em.createNativeQuery("UPDATE book SET publisherid = ? WHERE id = ?")
                    .setParameter(1, storedPublisher).setParameter(2, newBookId).executeUpdate();
        }
    }

    @RolesAllowed({"BSRead","BSWrite"})
    public List<Book> getAllBooks() {
        return em.createNamedQuery("Book.selectAll").getResultList();
    }

    @RolesAllowed({"BSRead","BSWrite"})
    public List<Book> getBookByTitle(String title) {
        return em.createNamedQuery("Book.selectByTitle").setParameter("title", "%" + title + "%").getResultList();
    }

    @RolesAllowed({"BSRead","BSWrite"})
    public List<Book> getBookById(int id) {
        return em.createNamedQuery("Book.selectById").setParameter("id", id).getResultList();
    }



    private int checkAuthor(List<Author> authorList, Author localAuthor) {
        int id = 0;

        for (int i = 0; i < authorList.size(); i++) {
            //Schauen ob der lokale Autor bereits in der DB vorhanden ist
            if (authorList.get(i).getFirstname().equals(localAuthor.getFirstname())
                    && authorList.get(i).getLastname().equals(localAuthor.getLastname())) {
                id = authorList.get(i).getId();
            }
        }

        return id;
    }

    public int checkPublisher(List<Publisher> publisherList, Publisher localPublisher) {
        int id = 0;

        for (int i = 0; i < publisherList.size(); i++) {
            if (publisherList.get(i).getName().equals(localPublisher.getName())) {
                id = publisherList.get(i).getId();
            }
        }

        return id;
    }
}
