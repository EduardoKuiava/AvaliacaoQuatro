package com.avaliacao.filiacao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.filiacao.entity.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

	List<Partido> findByIdeologia(String ideologia);
	
	
}
