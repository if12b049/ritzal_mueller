package com.bookserviceapp.businessobjects;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
@Entity
//@Embeddable
@Table(name="author")
@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
        @NamedQuery(name = "Author.selectAll",
                query = "SELECT a FROM Author a"),
        @NamedQuery(name = "Author.selectById",
                query = "SELECT a FROM Author a WHERE a.id = :id"),
        @NamedQuery(name = "Author.selectByName",
                query = "SELECT a FROM Author a WHERE a.firstname LIKE :name or a.lastname LIKE :name")
})
public class Author {
    /*inside database*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "id")
    private int id;
    @XmlAttribute(name = "firstname")
    private String firstname;
    @XmlAttribute(name = "lastname")
    private String lastname;
    @XmlAttribute(name = "birthdate")
    private String birthdate;
    @XmlTransient
    private String email = null;
    @XmlTransient
    private String telephone = null;

   /* @XmlTransient
    @ManyToMany(mappedBy="authorList", cascade = CascadeType.ALL)
    private List<Book> bookList;*/

    public Author(){super();}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
