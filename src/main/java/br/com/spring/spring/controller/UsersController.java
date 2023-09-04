package br.com.spring.spring.controller;

import br.com.spring.spring.domain.RequestUsersDTO;
import br.com.spring.spring.domain.User;
import br.com.spring.spring.domain.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity registerUser(@RequestBody @Valid RequestUsersDTO data) {
        User newUser = new User(data);
        repository.save(newUser);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/update")
    public ResponseEntity updateUser( @RequestBody @Valid RequestUsersDTO data) {
        Optional<User> optionalUser = repository.findById(data.id());

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(data.name());
            user.setActive(data.active());
            user.setPassword((data.password()));

            return ResponseEntity.ok(user);
        } else {
            throw new EntityNotFoundException();
        }


    }

}
