package springFramework.springPetClinic.services.map;


import org.springframework.stereotype.Service;
import springFramework.springPetClinic.model.PetType;
import springFramework.springPetClinic.services.IPetType;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements IPetType {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}