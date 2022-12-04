package com.smn.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smn.web.model.Ciudad;
/**
 * 
 * @author Kruger Lisandro
 *
 */
@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long>{
	
}
