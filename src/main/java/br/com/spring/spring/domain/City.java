package br.com.spring.spring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cities")
@Table(name = "cities")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
}
