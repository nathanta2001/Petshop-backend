package com.nathan.petshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.petshop.model.Pet;
import com.nathan.petshop.service.PetService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {

    public final PetService petService;

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id){
        Pet pet = petService.getPet(id);
        return ResponseEntity.ok().body(pet);
    }

    @GetMapping("")
    public ResponseEntity<List<Pet>> getPetList(){
        return ResponseEntity.ok().body(petService.getPetList());
    }

    @PostMapping("")
    public ResponseEntity<Pet> insertPet(@RequestBody Pet pet){
        Pet petAux = petService.insertPet(pet);
        return ResponseEntity.ok().body(petAux);
    }

    @PutMapping("")
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet){
        Pet petAux = petService.updatePet(pet);
        return ResponseEntity.ok().body(petAux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deletePet(@PathVariable Long id){
        Pet petAux = petService.deletePet(id);
        return ResponseEntity.ok().body(petAux);
    }
}

