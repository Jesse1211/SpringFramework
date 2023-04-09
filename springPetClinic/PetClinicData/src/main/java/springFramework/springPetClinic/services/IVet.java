package springFramework.springPetClinic.services;

import springFramework.springPetClinic.model.Vet;

import java.util.Set;

public interface IVet {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}