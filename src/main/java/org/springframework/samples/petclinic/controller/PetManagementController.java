package org.springframework.samples.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Pets;
import org.springframework.samples.petclinic.service.PetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/petClinic")
public class PetManagementController {

	@Autowired
	PetService petService;

	@GetMapping("/home")
	public String getData() {
		return "Pet Clinic Application";
	}

	@PostMapping("/addPet")
	public ResponseEntity<Pets> createPet(@RequestBody Pets pet) {
		Pets saved = petService.savePet(pet);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("/getPet/{id}")
	public ResponseEntity<Pets> getPetById(@PathVariable int id) {
		return petService.getPetById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/getAllPets")
	public List<Pets> getAllPets() {
		return petService.getAllPets();
	}

}
