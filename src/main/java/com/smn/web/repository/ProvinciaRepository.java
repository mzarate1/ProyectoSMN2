package com.smn.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smn.web.model.Provincia;
/**
 * 
 * @author Kruger Lisandro
 *
 */
@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>  {
	
}
