package businessobjects;

import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
public class Publisher {
    /*inside database*/
    private int id;
    private String name;
    private String postcode;
    private String countrycode;
    private String telephone;
    private String email;
    private String address;
    /*generated from other table*/
    private List<Book> published_books;
    private List<Author> employed_author;

    public Publisher(){super();}

    /*public Publisher(int id, String name, String postcode,
                     String countrycode, String telephone, String email,
                     String address, List<Book> published_books) {
        this.id = id;
        this.name = name;
        this.postcode = postcode;
        this.countrycode = countrycode;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.published_books = published_books;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getPublished_books() {
        return published_books;
    }

    public void setPublished_books(List<Book> published_books) {
        this.published_books = published_books;
    }


}
