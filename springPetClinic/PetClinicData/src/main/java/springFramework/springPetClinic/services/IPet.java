package springFramework.springPetClinic.services;

import springFramework.springPetClinic.model.Pet;

import java.util.Set;

public interface IPet {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}