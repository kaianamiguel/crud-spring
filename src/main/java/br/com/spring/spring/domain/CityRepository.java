package br.com.spring.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository  extends JpaRepository<City, String> {
}
