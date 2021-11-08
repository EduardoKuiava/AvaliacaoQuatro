package com.avaliacao.filiacao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.filiacao.entity.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

	List<Associado> findByCargoPolitico(String cargoPolitico);
	
}
