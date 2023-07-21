package br.com.spring.spring.controller;

import br.com.spring.spring.domain.City;
import br.com.spring.spring.domain.CityRepository;
import br.com.spring.spring.domain.DTO.RequestCitiesDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CityRepository repository;

    @GetMapping
    public ResponseEntity getAllCities() {
        var allCities = repository.findAll();

        return ResponseEntity.ok(allCities);

    }

    @PostMapping("/register")
    public ResponseEntity registerCities(@RequestBody @Valid RequestCitiesDTO data) {
        City newCity = new City(data);
        repository.save(newCity);

        return ResponseEntity.ok().build();
    }
}
