package SpringFramework.Web1.repositories;

import SpringFramework.Web1.Domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> { // <type, id_value>
}
