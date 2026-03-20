package com.nathan.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathan.petshop.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByNomeContaining(String nome);

}
