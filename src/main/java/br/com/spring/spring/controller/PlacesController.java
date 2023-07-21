package br.com.spring.spring.controller;

import br.com.spring.spring.domain.DTO.RequestPlacesDTO;
import br.com.spring.spring.domain.Place;
import br.com.spring.spring.domain.PlaceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity registerPlaces(@RequestBody @Valid RequestPlacesDTO data){
        Place newPlace = new Place(data);
        repository.save(newPlace);

        return ResponseEntity.ok(newPlace);
    }
}
