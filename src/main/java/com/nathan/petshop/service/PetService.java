package com.nathan.petshop.service;

import java.util.ArrayList;
import java.util.List;

import com.nathan.petshop.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nathan.petshop.model.Pet;
import com.nathan.petshop.repository.PetRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet getPet(Long id){
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Informação não encontrada.");
        }
        return pet;
    }

    public List<Pet> getPetList(){
        return petRepository.findAll();
    }

    public Pet insertPet(Pet pet){
        pet.setId(null);
        petRepository.save(pet);
        return pet;
    }

    public Pet updatePet(Pet pet){
        if (pet.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id é obrigatório.");
        }
        petRepository.save(pet);
        return pet;
    }

    public Pet deletePet(Long id){
        Pet pet = this.getPet(id);
        if (pet == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado um pet com o id: " + id);
        }

        petRepository.deleteById(id);

        return pet;
    }

}

