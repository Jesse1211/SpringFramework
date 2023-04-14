package springFramework.springPetClinic.services.map;

import org.springframework.stereotype.Service;
import springFramework.springPetClinic.model.Speciality;
import springFramework.springPetClinic.model.Vet;
import springFramework.springPetClinic.services.ISpecialty;
import springFramework.springPetClinic.services.IVet;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements IVet {
    private final ISpecialty specialtiesService;

    public VetServiceMap(ISpecialty specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpecialty = specialtiesService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}