package businessobjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
@Entity
@Table(name="author")
@XmlRootElement
public class Author {
    /*inside database*/
    @Id @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String email;
    private String telephone;

    /*generated with other tables*/

    public Author(){super();}


    /*public Author(int authorId, String firstname, String lastname,
                  Date birthdate, List<Book> writtenBooks,
                  String email, String telephone) {
        this.id = authorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.writtenBooks = writtenBooks;
        this.email = email;
        this.telephone = telephone;
    }*/
}
