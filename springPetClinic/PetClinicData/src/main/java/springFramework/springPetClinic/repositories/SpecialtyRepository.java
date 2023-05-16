package springFramework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springFramework.springPetClinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
