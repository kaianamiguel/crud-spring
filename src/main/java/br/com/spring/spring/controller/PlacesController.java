package br.com.spring.spring.controller;

import br.com.spring.spring.domain.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/places")
public class PlacesController {

    @Autowired
    private PlaceRepository repository;

    @GetMapping
    public ResponseEntity getAllPlaces() {
        var allPlaces = repository.findAll();

        return ResponseEntity.ok(allPlaces);
    }

    @PostMapping("/register")
    public ResponseEntity registerPlace(@RequestBody @Valid RequestPlacesDTO data){
        Place newPlace = new Place(data);
        repository.save(newPlace);

        return ResponseEntity.ok(newPlace);
    }

    @PutMapping("/update")
    public ResponseEntity updatePlace(@RequestBody @Valid RequestPlacesDTO data) {
        Optional<Place> placeOptional = repository.findById(data.id());

        if (placeOptional.isPresent()) {
            Place place = placeOptional.get();

            place.setName(data.name());
            place.setAddress(data.address());
            place.setCities_id(data.cities_id());
            place.setCategories_id(data.categories_id());
            place.setValue_in_cents(data.value_in_cents());

            repository.save(place);

            return ResponseEntity.ok(place);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
