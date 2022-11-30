package com.smn.web.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smn.web.model.Pronostico;

@Repository
public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {

	@Query("SELECT p FROM Pronostico p WHERE p.ciudad.id_ciudad=?1 and (p.fechaPronostico>=?2 and p.fechaPronostico < =?3)")
	List<Pronostico> findByIdCiudadFecha(Long idCiudadSeleccionada, Date fechaactual, Date fechaextendida);

}
