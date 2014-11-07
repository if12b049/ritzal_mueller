package businessobjects;

import businessobjects.Author;
import businessobjects.Publisher;

import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */

public class Book {
    /*inside database*/
    private int id;
    private String ISBN;
    private String subtitle;
    private String description;
    private int pages;
    private String language;
    /*generated from other table*/
    private Publisher publisher;
    private List<Author> author;

    public Book() { super(); }


    /*public Book(int id, String ISBN, String description, int pages, String languages, List<Author> authors) {
        this.id = id;
        this.ISBN = ISBN;
        this.description = description;
        this.pages = pages;
        this.language = languages;
        this.authors = authors;
    }*/

    private List<Author> authors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
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

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
