package com.bookserviceapp.businessobjects;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Created by Roman on 21.10.2014.
 */
@Entity
@Table(name="publisher")

@XmlRootElement(name = "publisher")
@XmlAccessorType(XmlAccessType.FIELD)

public class Publisher {
    /*inside database*/
    @Id
    @GeneratedValue
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

    /*@XmlTransient
    @OneToMany(mappedBy = "publisher") //, cascade = CascadeType.PERSIST
    private List<Book> bookList;*/

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
