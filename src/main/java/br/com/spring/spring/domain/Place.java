package br.com.spring.spring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "places")
@Table(name = "places")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String address;

    @ManyToOne
    @JoinColumn(name = "cities_id")
    private City cities_id;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category categories_id;

    private Integer value_in_cents;
}
