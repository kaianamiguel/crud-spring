package br.com.spring.spring.controller;

import br.com.spring.spring.domain.City;
import br.com.spring.spring.domain.CityRepository;
import br.com.spring.spring.domain.RequestCitiesDTO;
import br.com.spring.spring.domain.City;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity registerCity(@RequestBody @Valid RequestCitiesDTO data) {
        City newCity = new City(data);
        repository.save(newCity);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity updateCity(@RequestBody @Valid RequestCitiesDTO data) {
        Optional<City> cityOptional = repository.findById(data.id());

        if(cityOptional.isPresent()) {
            City city = cityOptional.get();

            city.setName(data.name());

            repository.save(city);

            return ResponseEntity.ok(city);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCity(@PathVariable String id){
        Optional<City> optionalCity = repository.findById(id);
        if (optionalCity.isPresent()) {
            City city = optionalCity.get();
            city.setActive(false);

            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }

}
