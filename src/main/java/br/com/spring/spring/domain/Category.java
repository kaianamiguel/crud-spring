package br.com.spring.spring.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "categories")
@Table(name = "categories")
@EqualsAndHashCode (of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    private String name;
}
