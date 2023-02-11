package SpringFramework.Web1.bootstrap;

import SpringFramework.Web1.Domain.Author;
import SpringFramework.Web1.Domain.Book;
import SpringFramework.Web1.Domain.Publisher;
import SpringFramework.Web1.repositories.AuthorRepository;
import SpringFramework.Web1.repositories.BookRepository;
import SpringFramework.Web1.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // as a spring managed component
public class BootStrapData implements CommandLineRunner {

    // Dependency Injection:
    // when spring implements the component, do dependency injection into constructor for instance of author and book
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    // Constructor
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    /***
     * set up information for author and book,
     * and add in a book to the author, and author to the book by removing the constructor
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Davis");
        publisher.setState("CA");
        // Save one by one
        publisherRepository.save(publisher);    // save() from CrudRepository
        System.out.println("Publisher count:" + publisherRepository.count() );

        Author lzh = new Author("Zhenhua", "Liu");
        Book book1 = new Book("Domain Driven Design", "0001");
        lzh.getBooks().add(book1);    // getBooks() from Domain, add() from set
        book1.getAuthors().add(lzh);

        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        authorRepository.save(lzh);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Author Jesse = new Author("Jesse", "Liu");
        Book book2 = new Book("scary", "0002");
        Jesse.getBooks().add(book2);
        book2.getAuthors().add(Jesse);

        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        authorRepository.save(Jesse);
        bookRepository.save(book2);
        publisherRepository.save(publisher); // 问题 为什么一定要最后一个存储它z

        System.out.println("BootStrapData: ");
        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Publisher number of books:" + publisher.getBooks().size());
    }
}
