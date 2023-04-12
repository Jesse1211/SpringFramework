package springFramework.springPetClinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springFramework.springPetClinic.model.Owner;
import springFramework.springPetClinic.model.Vet;
import springFramework.springPetClinic.services.IOwner;
import springFramework.springPetClinic.services.IVet;
import springFramework.springPetClinic.services.map.OwnerServiceMap;
import springFramework.springPetClinic.services.map.VetServiceMap;

/** Initialize data by implementing CommandLineRunner
 *
 */
@Component // be springBean and registered into spring context, execute fun()  if the spring context is ready
public class DataLoader implements CommandLineRunner {

    private final IOwner ownerService;
    private final IVet vetService;

    // DI
    public DataLoader(IOwner ownerService, IVet vetService) {
        // Spring sees IOwner, it will scan OwnerServiceMap due to @Service
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    // Load data:
    @Override
    public void run(String... args) throws Exception {

        // Owner:   id,     firstname,    last name
        //          -      Micheal     Weston
        //          -      Fiona       Glenna

        // Vet:     id,     firstname,    last name
        //          -      Sam         Axe
        //          -      Jessie      Porter
        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenna");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}