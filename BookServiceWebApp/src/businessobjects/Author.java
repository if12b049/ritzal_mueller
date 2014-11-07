package businessobjects;

import java.sql.Date;
import java.util.List;

/**
 * Created by Roman on 21.10.2014.
 */
public class Author {
    /*inside database*/
    private int id;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String email;
    private String telephone;

    /*generated with other tables*/
    private List<Book> writtenBooks;

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
