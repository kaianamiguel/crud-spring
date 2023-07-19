package br.com.spring.spring.domain;

import br.com.spring.spring.domain.DTO.RequestUsersDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer active;

    private String password;

    public User(@Valid RequestUsersDTO requestUsersDTO) {
        this.name = requestUsersDTO.name();
        this.active = requestUsersDTO.active();
        this.password = requestUsersDTO.password();
    }

}
