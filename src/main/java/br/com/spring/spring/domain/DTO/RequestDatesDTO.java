package br.com.spring.spring.domain.DTO;

import br.com.spring.spring.domain.Place;
import br.com.spring.spring.domain.User;

import java.time.LocalDateTime;

public record RequestDatesDTO(User user, User user1, LocalDateTime date, Place place) {

}
