package br.com.spring.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "cities")
@Table(name = "cities")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    public City(RequestCitiesDTO requestCitiesDTO) {
        this.name = requestCitiesDTO.name();
    }

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
