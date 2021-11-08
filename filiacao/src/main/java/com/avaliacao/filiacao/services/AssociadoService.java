package com.avaliacao.filiacao.services;

import java.util.List;

import com.avaliacao.filiacao.dto.AssociadoDTO;
import com.avaliacao.filiacao.dto.AssociadoFormDTO;


public interface AssociadoService {
	
	//POST - /associados
	AssociadoDTO salvar (AssociadoFormDTO body);
	
	
	//POST - /associados/partidos (Vincula um associado a um partido, body: {idAssociado: '10', idPartido: '10'})
	AssociadoDTO Vincular(Long idAssociado, Long idPartido);
	
	//GET - /associados (Ter uma opção de filtrar associados de acordo com seu cargo político)
	List<AssociadoDTO> listarPorCargo(String cargoPolitico);//ver parametro
	
		
	//GET - /associados/{id}
	AssociadoDTO detalhar(Long id);//ver parametro
	
	
	//PUT - /associados/{id}
	AssociadoDTO atualizar(Long id, AssociadoFormDTO body);
	
	
	//DELETE - /associados/{id}
	void remover(Long id);
	
	
	//DELETE - /associados/{id}/partidos/{id} (Remove determinado associado daquele partido)
	void removerVinculado(Long ida, Long idp);
}
