package springFramework.springPetClinic.services;

import springFramework.springPetClinic.model.Owner;

import java.util.Set;

public interface IOwner {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}