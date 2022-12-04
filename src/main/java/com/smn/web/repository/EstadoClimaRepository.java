package com.smn.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smn.web.model.EstadoClima;
/**
 * 
 * @author Kruger Lisandro
 *
 */
@Repository
public interface EstadoClimaRepository extends JpaRepository<EstadoClima, Long>{

}
