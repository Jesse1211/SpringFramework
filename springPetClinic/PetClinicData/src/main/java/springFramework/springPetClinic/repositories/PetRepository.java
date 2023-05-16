package springFramework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springFramework.springPetClinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}