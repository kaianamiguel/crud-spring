package br.com.spring.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, String> {
}