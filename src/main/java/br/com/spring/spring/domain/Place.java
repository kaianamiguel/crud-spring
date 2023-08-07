package br.com.spring.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "places")
@Table(name = "places")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cities_id", referencedColumnName = "id")
    private City cities_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    private Category categories_id;

    private Integer value_in_cents;

    public Place(RequestPlacesDTO requestPlacesDTO) {
        this.name = requestPlacesDTO.name();
        this.address = requestPlacesDTO.address();
        this.cities_id = requestPlacesDTO.cities_id();
        this.categories_id = requestPlacesDTO.categories_id();
        this.value_in_cents = requestPlacesDTO.value_in_cents();
    }
}
