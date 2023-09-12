package br.com.spring.spring.controller;

import br.com.spring.spring.domain.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dates")
public class DatesController {

    @Autowired
    private DateRepository repository;

    @GetMapping
    public ResponseEntity getAllDates() {
        var allDates = repository.findAll();
        return ResponseEntity.ok(allDates);
    }

    @PostMapping("/register")
    public ResponseEntity registerDate(@RequestBody @Valid RequestDatesDTO data) {
        Date newDate = new Date(data);
        repository.save(newDate);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/update")
    public ResponseEntity updateDate(@RequestBody @Valid RequestDatesDTO data) {
        Optional<Date> dateOptional = repository.findById(data.id());

        if (dateOptional.isPresent()) {
            Date date = dateOptional.get();

            date.setUser(data.user());
            date.setUser1(data.user1());
            date.setDate(data.date());
            date.setPlace(data.place());

            repository.save(date);

            return ResponseEntity.ok(date);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
