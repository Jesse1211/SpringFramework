package springFramework.springPetClinic.services.map;

import org.springframework.stereotype.Service;
import springFramework.springPetClinic.model.Pet;
import springFramework.springPetClinic.services.ICrud;
import springFramework.springPetClinic.services.IPet;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements IPet {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}