package springFramework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springFramework.springPetClinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
