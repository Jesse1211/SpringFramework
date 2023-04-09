package springFramework.springPetClinic.services.map;

import springFramework.springPetClinic.model.Owner;
import springFramework.springPetClinic.services.ICrud;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements ICrud<Owner, Long> {
    /**
    * super.method(): use methods in AbstractMapService
    * */
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
