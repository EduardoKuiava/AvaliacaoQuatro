package com.avaliacao.filiacao.services;

import java.util.List;

import com.avaliacao.filiacao.dto.PartidoDTO;
import com.avaliacao.filiacao.dto.PartidoFormDTO;


public interface PartidoService {
	
	//POST - /partidos
	PartidoDTO salvar (PartidoFormDTO body);
	
	
	//GET - /partidos (Ter uma opção de filtrar partidos de acordo com sua ideologia)
	List<PartidoDTO> listarPorIdeologia(String ideologia);
	
	
	//GET - /partidos/{id}
	PartidoDTO listarAssociados(Long id);
	
	
	//GET - /partidos/{id}/associados (Listar todos os associados daquele partido)
	PartidoDTO detalhar(Long id);
	
	
	//PUT - /partidos/{id}
	PartidoDTO atualizar(Long id, PartidoFormDTO body);
	
	
	//DELETE - /partidos/{id}
	void remover(Long id);
}
