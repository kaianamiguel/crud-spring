package br.com.spring.spring.domain;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "categories")
@Table(name = "categories")
@EqualsAndHashCode (of = "id")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
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
