package br.com.spring.spring.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.io.Serializable;

@Entity(name = "users")
@Table(name = "users")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

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
