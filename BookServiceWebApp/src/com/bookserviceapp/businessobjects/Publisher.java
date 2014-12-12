package com.bookserviceapp.businessobjects;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
@Entity
@Table(name="publisher")

@XmlRootElement(name = "publisher")
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
        @NamedQuery(name = "Publisher.selectAll",
                query = "SELECT p FROM Publisher p"),
        @NamedQuery(name = "Publisher.selectById",
                query = "SELECT p FROM Publisher p WHERE p.id = :id"),
        @NamedQuery(name = "Publisher.selectByName",
                query = "SELECT p FROM Publisher p WHERE p.name LIKE :name")
})

public class Publisher {
    /*inside database*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "id")
    @Column(name = "id")
    private int id;
    @XmlAttribute(name = "name")
    @Column(name = "name")
    private String name = null;
    @XmlAttribute(name = "postcode")
    @Column(name = "postcode")
    private String postcode = null;
    @XmlAttribute(name = "countrycode")
    @Column(name = "countrycode")
    private String countrycode= null;

    @XmlTransient
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL) //, cascade = CascadeType.PERSIST
    private List<Book> bookList;

    public Publisher(){super();}

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

}
