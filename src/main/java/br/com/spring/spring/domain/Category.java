package br.com.spring.spring.domain;


import br.com.spring.spring.domain.DTO.RequestCategoriesDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "categories")
@Table(name = "categories")
@EqualsAndHashCode (of = "id")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    private String name;

    public Category(RequestCategoriesDTO requestCategoriesDTO) {
        this.name = requestCategoriesDTO.name();
    }

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
