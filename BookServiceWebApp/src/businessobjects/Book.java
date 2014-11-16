package businessobjects;

import businessobjects.Author;
import businessobjects.Publisher;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
@Entity
@Table(name="book")
@XmlRootElement(name = "book")

@NamedQuery(name = "Books.selectAll",
        query = "SELECT b FROM Book b")
/*@NamedQueries({
        @NamedQuery(name = "Books.selectAll",
                query = "SELECT b FROM Book b"),
        @NamedQuery(name = "Books.select",
                query = "SELECT b FROM Book b WHERE Book.description= ?1"),
})*/

public class Book {
    /*
    * TODO: Der Titel des Buches fehlt komplett, in DB und in Klasse ausbessern*/

    /*inside database*/
    @Id @GeneratedValue
    private int id;
    private String ISBN;
    private String subtitle;
    private String description;
    private int pages;
    private String language;

    /*generated from other table*/
    //private Publisher publisher;
    //private List<Author> author;

    public Book(){}

    /*public Book(Publisher publisher) { super();
        this.publisher = publisher;
    }*/


    /*public Book(int id, String ISBN, String description, int pages, String languages, List<Author> authors) {
        this.id = id;
        this.ISBN = ISBN;
        this.description = description;
        this.pages = pages;
        this.language = languages;
        this.authors = authors;
    }*/
    @XmlTransient
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlAttribute
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    @XmlAttribute
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    @XmlAttribute
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @XmlAttribute
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    @XmlAttribute
    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
