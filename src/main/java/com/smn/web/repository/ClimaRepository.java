package com.smn.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smn.web.model.Clima;
/**
 * 
 * @author Kruger Lisandro
 *
 */
@Repository
public interface ClimaRepository extends JpaRepository<Clima, Long> {

}
