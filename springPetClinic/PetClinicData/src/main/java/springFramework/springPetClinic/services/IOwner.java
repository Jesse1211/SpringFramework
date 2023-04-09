package springFramework.springPetClinic.services;

import springFramework.springPetClinic.model.Owner;

public interface IOwner extends ICrud<Owner, Long> {

    Owner findByLastName(String lastName);
}