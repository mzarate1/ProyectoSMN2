package com.smn.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smn.web.model.Pronostico;


@Repository
public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {

}
