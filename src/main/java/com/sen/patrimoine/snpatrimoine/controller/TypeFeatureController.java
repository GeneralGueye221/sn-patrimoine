package com.sen.patrimoine.snpatrimoine.controller;


import com.sen.patrimoine.snpatrimoine.model.TypeFeature;

import com.sen.patrimoine.snpatrimoine.repository.TypeFeatureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TypeFeatureController {

    //Variable d'instance
    @Autowired
    private TypeFeatureRepository typeFeatureRepository;

    //Constructor
    public TypeFeatureController(TypeFeatureRepository repository){
        this.typeFeatureRepository = repository;
    }

    //Controller Layer of FEATURE

    //REQUEST MAPPING
    @GetMapping("/type_features")
    Collection<TypeFeature>typeFeatures(){
        return typeFeatureRepository.findAll();
    }
    @GetMapping("/type_feature/{id}")
    ResponseEntity<?> getTypeFeature(@PathVariable Long id){
        Optional<TypeFeature> typeFeature = typeFeatureRepository.findById(id);
        return typeFeature.map(response->ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/type_feature")
    ResponseEntity<TypeFeature> createTypeFeature(@Valid @RequestBody TypeFeature typeFeature) throws URISyntaxException {
        TypeFeature result = typeFeatureRepository.save(typeFeature);
        return ResponseEntity.created(new URI("/api/type_feature/"+result.getId())).body(result);
    }

    @PutMapping("/type_feature/{id}")
    ResponseEntity<TypeFeature> updateTypeFeature(@Valid @RequestBody TypeFeature typeFeature){
        TypeFeature result = typeFeatureRepository.save(typeFeature);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/type_feature/{id}")
    ResponseEntity<?> deleteTypeFeature(@PathVariable Long id){
        typeFeatureRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
