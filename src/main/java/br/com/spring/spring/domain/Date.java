package br.com.spring.spring.domain;

import br.com.spring.spring.domain.DTO.RequestDatesDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "dates")
@Table(name = "dates")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Date {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "users_id1")
    private User user1;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "places_id")
    private Place place;

    public Date(@Valid RequestDatesDTO requestDatesDTO) {
        this.user = requestDatesDTO.user();
        this.user1 = requestDatesDTO.user1();
        this.date = requestDatesDTO.date();
        this.place = requestDatesDTO.place();
    }
}
