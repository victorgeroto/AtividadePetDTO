package com.projetodtoH2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetodtoH2.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}

