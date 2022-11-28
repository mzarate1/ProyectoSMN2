package com.smn.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smn.web.model.Pronostico;


@Repository
public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {

	@Query("SELECT c FROM Pronostico c WHERE c.id_ciudad = id_ciudad")
	List <Pronostico> findByIdCiudad(Long id_ciudad);

}
