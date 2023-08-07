package br.com.spring.spring.controller;

import br.com.spring.spring.domain.Date;
import br.com.spring.spring.domain.DateRepository;
import br.com.spring.spring.domain.RequestDatesDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
