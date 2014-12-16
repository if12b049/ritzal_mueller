
import com.bookserviceapp.application.Book;
import com.bookserviceapp.application.BookSOAPWebService;
import com.bookserviceapp.application.BookSOAPWebServiceImplService;

import javax.jws.WebMethod;
import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.List;


public class BookSOAPWebserviceClient {
    public static void main(String[] args) {

        BookSOAPWebServiceImplService service = new BookSOAPWebServiceImplService();
        BookSOAPWebService port = service.getBookSOAPWebServiceImplPort();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String eingabe = null;
        Books books = null;


        System.out.println("Bitte Pfad des Buches eingeben: ");
        try {
            eingabe = reader.readLine();
            System.out.println("Ihre Eingabe: " + eingabe);
            books = parseFileToObject(eingabe);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Book> bookList = books.getBookList();

        for(int i=0;i<bookList.size(); i++){

            Book book = new Book();

            book.setAuthors(bookList.get(i).getAuthors());
            book.setISBN(bookList.get(i).getISBN());
            book.setDescription(bookList.get(i).getDescription());
            book.setLanguage(bookList.get(i).getLanguage());
            book.setPages(bookList.get(i).getPages());
            book.setPublisher(bookList.get(i).getPublisher());
            book.setSubtitle(bookList.get(i).getSubtitle());
            book.setTitle(bookList.get(i).getTitle());

            JAXBContext jaxbContext = null;
            try {
                jaxbContext = JAXBContext.newInstance(Book.class);
                Marshaller marshaller = jaxbContext.createMarshaller();

                marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                marshaller.marshal(book, System.out);
                marshaller.marshal(book, new File("xml/Test.xml"));
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            port.importBook(book);
        }
    }

    private static Books parseFileToObject(String path){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            //Falls kein Header http://stackoverflow.com/questions/3039998/explanation-of-jaxb-error-invalid-byte-1-of-1-byte-utf-8-sequence

            Source source = new StreamSource(new File(path));
            JAXBElement<Books> jaxbElement = unmarshaller.unmarshal(source, Books.class);
            Books books = jaxbElement.getValue();

            return books;

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }




}
