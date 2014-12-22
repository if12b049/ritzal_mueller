

import com.bookserviceapp.application.Book;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Roman on 14.12.2014.
 */

@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
public class Books {
    @XmlElement(name = "book")
    private List<Book> bookList = null;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
