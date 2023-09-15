package br.com.spring.spring.domain;

import br.com.spring.spring.domain.Category;
import br.com.spring.spring.domain.City;

public record RequestPlacesDTO(String id, Boolean active,  String name, String address, City cities_id, Category categories_id, Integer value_in_cents) {
}
