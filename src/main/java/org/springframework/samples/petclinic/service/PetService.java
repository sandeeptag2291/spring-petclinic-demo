package org.springframework.samples.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pets;
import org.springframework.samples.petclinic.repository.PetRepo;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	@Autowired
	PetRepo petRepo;

	public Pets savePet(Pets pet) {
		return petRepo.save(pet);
	}

	public Optional<Pets> getPetById(int id) {
		return petRepo.findById(id);
	}

	public List<Pets> getAllPets() {
		return petRepo.findAll();
	}

}
