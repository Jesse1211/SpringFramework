package SpringFramework.Web1.repositories;

import SpringFramework.Web1.Domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
