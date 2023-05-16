package springFramework.springPetClinic.repositories;

import springFramework.springPetClinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
