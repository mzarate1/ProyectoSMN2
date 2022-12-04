package com.smn.web.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smn.web.model.Pronostico;

@Repository
public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {


	//@Query(value = "SELECT * FROM Pronostico WHERE p.id_ciudad=?0 and p.fechaPronostico>=?1 and p.fechaPronostico <=?2", nativeQuery = true)
	//List<Pronostico> findByFilter(Long idCiudadSeleccionada, Date fechaactual, Date fechaextendida);
	
@Query(value = "SELECT * FROM Pronostico WHERE DATE_FORMAT(p.fecha_pronostico, \"%d/%m/%Y\") > ?0", nativeQuery = true)
List<Pronostico> findByFecha(LocalDate date);
	


}
