package br.com.spring.spring.domain;

import br.com.spring.spring.domain.Place;
import br.com.spring.spring.domain.User;

import java.time.LocalDateTime;

public record RequestDatesDTO(String id, User user, User user1, LocalDateTime date, Place place) {

}
