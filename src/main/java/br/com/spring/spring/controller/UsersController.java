package br.com.spring.spring.controller;

import br.com.spring.spring.domain.DTO.RequestUsersDTO;
import br.com.spring.spring.domain.User;
import br.com.spring.spring.domain.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity getAllUsers() {
        var allUsers = repository.findAll();

        return ResponseEntity.ok(allUsers);
    }

    @PostMapping("/register")
    public ResponseEntity registerUsers(@RequestBody @Valid RequestUsersDTO data) {
        User newUser = new User(data);
        repository.save(newUser);

        return ResponseEntity.ok().build();

    }

}
