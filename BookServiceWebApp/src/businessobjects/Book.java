package businessobjects;

import businessobjects.Author;
import businessobjects.Publisher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
@Entity
@Table(name="book")
@XmlRootElement(name = "book")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }
    @XmlAttribute
    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }
    @XmlAttribute
    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }
    @XmlAttribute
    public void setDescription(String description) {
        this.description = description;
    }

    public String getISBN() {
        return ISBN;
    }
    @XmlAttribute
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getSubtitle() {
        return subtitle;
    }
    @XmlAttribute
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
