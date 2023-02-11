package SpringFramework.Web1.bootstrap;

import SpringFramework.Web1.Domain.Author;
import SpringFramework.Web1.Domain.Book;
import SpringFramework.Web1.repositories.AuthorRepository;
import SpringFramework.Web1.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // as a spring managed component
public class BootStrapData implements CommandLineRunner {

    // Dependency Injection:
    // when spring implements the component, do dependency injection into constructor for instance of author and book
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    // Constructor
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        set up information for author and book,
//        and add in a book to the author, and author to the book by removing the constructor
        Author author = new Author("Zhenhua", "Liu");
        Book book = new Book("topdown", "0001");

        author.getBooks().add(book);    // getBooks() from Domain, add() from set
        book.getAuthors().add(author);

        authorRepository.save(author); // save() from CrudRepository
        bookRepository.save(book);

        Author author2 = new Author("Jesse", "Liu");
        Book book2 = new Book("scary", "0002");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        // Save one by one
        authorRepository.save(author);
        bookRepository.save(book);

        System.out.println("BootStrapData: ");
        System.out.println("Number of books:" + bookRepository.count());
    }
}
