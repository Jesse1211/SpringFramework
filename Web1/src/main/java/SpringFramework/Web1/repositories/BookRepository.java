package SpringFramework.Web1.repositories;

import SpringFramework.Web1.Domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
