package org.springframework.samples.petclinic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Pets;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Nonnull;

@Repository
public interface PetRepo extends JpaRepository<Pets, Integer> {

	@Transactional
	Optional<Pets> findById(Integer id);

}
