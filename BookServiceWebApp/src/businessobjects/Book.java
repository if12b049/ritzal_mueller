package businessobjects;

import businessobjects.Author;
import businessobjects.Publisher;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
@Entity
@Table(name="book")
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
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
    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    private int id;
    @XmlAttribute(name = "ISBN")
    private String ISBN;
    @XmlAttribute(name = "subtitle")
    private String subtitle;
    @XmlAttribute(name = "description")
    private String description;
    @XmlAttribute(name = "pages")
    private int pages;
    @XmlAttribute(name = "language")
    private String language;

    /*generated from other table*/
    @XmlElement(name = "publisher", type = Publisher.class)
    private Publisher publisher;
    //@XmlElementWrapper(name = "authors")
    @XmlElement(name = "author", type = Author.class)
    private Author author;

    /*@XmlElement
    private int publisherid;
    @XmlElement
    private int authorid;*/



    /*public Book(Publisher publisher, Author author){
        this.publisher = publisher;
        this.author = author;
    }*/

    public Book() {  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
