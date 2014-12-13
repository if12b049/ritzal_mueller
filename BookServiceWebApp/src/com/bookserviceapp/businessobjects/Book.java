package com.bookserviceapp.businessobjects;

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

@NamedQueries({
        @NamedQuery(name = "Book.selectAll",
                query = "SELECT b FROM Book b"),
        @NamedQuery(name = "Book.selectById",
                query = "SELECT b FROM Book b WHERE b.id = :id"),
        @NamedQuery(name = "Book.selectByTitle",
                query = "SELECT b FROM Book b WHERE b.subtitle LIKE :title")
})

public class Book {
    /*inside database*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "id")
    @Column(name = "id")
    private long id;

    @XmlAttribute(name = "ISBN")
    @Column(name="ISBN")
    private String ISBN;

    @XmlAttribute(name = "title")
    @Column(name="title")
    private String title;

    @XmlAttribute(name = "subtitle")
    @Column(name="subtitle")
    private String subtitle;

    @XmlAttribute(name = "description")
    @Column(name="description")
    private String description;

    @XmlAttribute(name = "pages")
    @Column(name="pages")
    private int pages;

    @XmlAttribute(name = "language")
    @Column(name = "language")
    private String language;

    /*generated from other table*/
    @XmlElement(name = "publisher")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "publisherid", referencedColumnName = "id", nullable = false)
    private Publisher publisher;

    @XmlElementWrapper(name = "authors")
    @XmlElement(name = "author")
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="authorsbooks",
            joinColumns = {@JoinColumn(name = "bookid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authorid", referencedColumnName = "id")}
    )
    private List<Author> authorList;

    public Book(){ super();}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
