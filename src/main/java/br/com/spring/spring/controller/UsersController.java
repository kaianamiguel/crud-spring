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
    public ResponseEntity updateUser(@RequestBody @Valid RequestUsersDTO data) {
        //Busca o usuario pelo id e encapsula dentro de um Optional para não haver problemas de NullPointer
        Optional<User> optionalUser = repository.findById(data.id());

        //Verifica se o Optional está preenchido
        if(optionalUser.isPresent()) {

            //Pega o Optional e altera os dados
            User user = optionalUser.get();
            user.setName(data.name());
            user.setActive(data.active());
            user.setPassword((data.password()));

            repository.save(user);

            return ResponseEntity.ok(user);
        } else {
            throw new EntityNotFoundException();
        }


    }

}
