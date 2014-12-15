
package com.bookserviceapp.application;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bookserviceapp.application package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBookByTitle_QNAME = new QName("http://application.bookserviceapp.com/", "getBookByTitle");
    private final static QName _Publisher_QNAME = new QName("http://application.bookserviceapp.com/", "publisher");
    private final static QName _GetAllBooksResponse_QNAME = new QName("http://application.bookserviceapp.com/", "getAllBooksResponse");
    private final static QName _ImportBook_QNAME = new QName("http://application.bookserviceapp.com/", "importBook");
    private final static QName _ImportBookResponse_QNAME = new QName("http://application.bookserviceapp.com/", "importBookResponse");
    private final static QName _GetBookByTitleResponse_QNAME = new QName("http://application.bookserviceapp.com/", "getBookByTitleResponse");
    private final static QName _Book_QNAME = new QName("http://application.bookserviceapp.com/", "book");
    private final static QName _Author_QNAME = new QName("http://application.bookserviceapp.com/", "author");
    private final static QName _GetAllBooks_QNAME = new QName("http://application.bookserviceapp.com/", "getAllBooks");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bookserviceapp.application
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link GetAllBooks }
     * 
     */
    public GetAllBooks createGetAllBooks() {
        return new GetAllBooks();
    }

    /**
     * Create an instance of {@link GetBookByTitleResponse }
     * 
     */
    public GetBookByTitleResponse createGetBookByTitleResponse() {
        return new GetBookByTitleResponse();
    }

    /**
     * Create an instance of {@link ImportBookResponse }
     * 
     */
    public ImportBookResponse createImportBookResponse() {
        return new ImportBookResponse();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link GetAllBooksResponse }
     * 
     */
    public GetAllBooksResponse createGetAllBooksResponse() {
        return new GetAllBooksResponse();
    }

    /**
     * Create an instance of {@link GetBookByTitle }
     * 
     */
    public GetBookByTitle createGetBookByTitle() {
        return new GetBookByTitle();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new Publisher();
    }

    /**
     * Create an instance of {@link ImportBook }
     * 
     */
    public ImportBook createImportBook() {
        return new ImportBook();
    }

    /**
     * Create an instance of {@link Book.Authors }
     * 
     */
    public Book.Authors createBookAuthors() {
        return new Book.Authors();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://application.bookserviceapp.com/", name = "getBookByTitle")
    public JAXBElement<GetBookByTitle> createGetBookByTitle(GetBookByTitle value) {
        return new JAXBElement<GetBookByTitle>(_GetBookByTitle_QNAME, GetBookByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Publisher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://application.bookserviceapp.com/", name = "publisher")
    public JAXBElement<Publisher> createPublisher(Publisher value) {
        return new JAXBElement<Publisher>(_Publisher_QNAME, Publisher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://application.bookserviceapp.com/", name = "getAllBooksResponse")
    public JAXBElement<GetAllBooksResponse> createGetAllBooksResponse(GetAllBooksResponse value) {
        return new JAXBElement<GetAllBooksResponse>(_GetAllBooksResponse_QNAME, GetAllBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://application.bookserviceapp.com/", name = "importBook")
    public JAXBElement<ImportBook> createImportBook(ImportBook value) {
        return new JAXBElement<ImportBook>(_ImportBook_QNAME, ImportBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://application.bookserviceapp.com/", name = "importBookResponse")
    public JAXBElement<ImportBookResponse> createImportBookResponse(ImportBookResponse value) {
        return new JAXBElement<ImportBookResponse>(_ImportBookResponse_QNAME, ImportBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://application.bookserviceapp.com/", name = "getBookByTitleResponse")
    public JAXBElement<GetBookByTitleResponse> createGetBookByTitleResponse(GetBookByTitleResponse value) {
        return new JAXBElement<GetBookByTitleResponse>(_GetBookByTitleResponse_QNAME, GetBookByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://application.bookserviceapp.com/", name = "book")
    public JAXBElement<Book> createBook(Book value) {
        return new JAXBElement<Book>(_Book_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Author }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://application.bookserviceapp.com/", name = "author")
    public JAXBElement<Author> createAuthor(Author value) {
        return new JAXBElement<Author>(_Author_QNAME, Author.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://application.bookserviceapp.com/", name = "getAllBooks")
    public JAXBElement<GetAllBooks> createGetAllBooks(GetAllBooks value) {
        return new JAXBElement<GetAllBooks>(_GetAllBooks_QNAME, GetAllBooks.class, null, value);
    }

}
