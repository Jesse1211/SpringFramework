package springFramework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springFramework.springPetClinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
