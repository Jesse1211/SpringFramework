package springFramework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springFramework.springPetClinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}