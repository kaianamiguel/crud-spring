package br.com.spring.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, String> {
}