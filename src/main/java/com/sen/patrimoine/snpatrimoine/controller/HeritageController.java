package com.sen.patrimoine.snpatrimoine.controller;

import com.sen.patrimoine.snpatrimoine.model.Heritage;
import com.sen.patrimoine.snpatrimoine.repository.HeritageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HeritageController {

    //Variable d'instance
    @Autowired
    private HeritageRepository heritageRepository;

    //constructor
    public HeritageController(HeritageRepository repository){
        this.heritageRepository = repository;
    }

    //Heritage's Controller Layout

    //Sorting Heritage
    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    //GET REQUEST
    @GetMapping("/heritages")
    Collection<Heritage> heritages(){
        return heritageRepository.findAll();
    }
    @GetMapping("/sortedheritages")
    public ResponseEntity<List<Heritage>> getAllHeritages(@RequestParam(defaultValue = "id,desc") String[] sort) {

        try {
            List<Order> orders = new ArrayList<Order>();

            if (sort[0].contains(",")) {
                // will sort more than 2 columns
                for (String sortOrder : sort) {
                    // sortOrder="column, direction"
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[column, direction]
                orders.add(new Order(getSortDirection(sort[1]), sort[0]));
            }

            List<Heritage> heritages = heritageRepository.findAll(Sort.by(orders));

            if (heritages.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(heritages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/heritage/{id}")
    ResponseEntity<?> getHeritage(@PathVariable Long id){
        Optional<Heritage> heritage = heritageRepository.findById(id);
        return heritage.map(response->ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //POST REQUEST
    @PostMapping("/create_heritage")
    ResponseEntity<Heritage> createHeritage(@Valid @RequestBody Heritage heritage) throws URISyntaxException {
        Heritage result = heritageRepository.save(heritage);
        return ResponseEntity.created(new URI("/api/heritage/"+result.getId())).body(result);
    }

    //PUT REQUEST
    @PutMapping("/create_heritage/{id}")
    ResponseEntity<Heritage> updateHeritage(@Valid @RequestBody Heritage heritage){
        Heritage result = heritageRepository.save(heritage);
        return ResponseEntity.ok().body(result);
    }

    //DELETE REQUEST
    @DeleteMapping("/delete_heritage/{id}")
    ResponseEntity<?> deleteHeritage(@PathVariable Long id){
        heritageRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
