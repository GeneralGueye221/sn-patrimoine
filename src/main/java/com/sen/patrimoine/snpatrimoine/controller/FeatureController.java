package com.sen.patrimoine.snpatrimoine.controller;

import com.sen.patrimoine.snpatrimoine.model.Feature;
import com.sen.patrimoine.snpatrimoine.repository.FeatureRepository;
import org.apache.catalina.connector.Response;
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
public class FeatureController {

    //Variable d'instance
    @Autowired
    private FeatureRepository featureRepository;

    //Constructor
    public FeatureController(FeatureRepository repository){
        this.featureRepository = repository;
    }

    //Controller Layer of FEATURE

    //REQUEST MAPPING
    @GetMapping("/features")
    Collection<Feature>features(){
        return featureRepository.findAll();
    }
    @GetMapping("/feature/{id}")
    ResponseEntity<?> getFeature(@PathVariable Long id){
        Optional<Feature> feature = featureRepository.findById(id);
        return feature.map(response->ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/feature")
    ResponseEntity<Feature> createFeature(@Valid @RequestBody Feature feature) throws URISyntaxException {
        Feature result = featureRepository.save(feature);
        return ResponseEntity.created(new URI("/api/feature/"+result.getId())).body(result);
    }

    @PutMapping("/feature/{id}")
    ResponseEntity<Feature> updateFeature(@Valid @RequestBody Feature feature){
        Feature result = featureRepository.save(feature);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/feature/{id}")
    ResponseEntity<?> deleteFeature(@PathVariable Long id){
        featureRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
