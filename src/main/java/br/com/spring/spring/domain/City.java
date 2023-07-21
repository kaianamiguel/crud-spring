package br.com.spring.spring.domain;

import br.com.spring.spring.domain.DTO.RequestCitiesDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cities")
@Table(name = "cities")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class City {

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
