package com.avaliacao.filiacao.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.filiacao.Repository.PartidoRepository;
import com.avaliacao.filiacao.dto.PartidoDTO;
import com.avaliacao.filiacao.dto.PartidoFormDTO;
import com.avaliacao.filiacao.entity.Partido;
import com.avaliacao.filiacao.validacao.IdeologiaValidacao;

@Service
public class PartidoServiceImpl implements PartidoService {

	@Autowired
	private PartidoRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Autowired
	private IdeologiaValidacao ideologiaValidacao;
	

	//POST - /partidos
	@Override
	public PartidoDTO salvar(PartidoFormDTO body) {
		Partido partido = mapper.map(body, Partido.class);
		ideologiaValidacao.validaIdeologia(partido);
		Partido associadoResponse = this.repository.save(partido);
		return mapper.map(associadoResponse, PartidoDTO.class);		
	}

	
	//GET - /partidos (Ter uma opção de filtrar partidos de acordo com sua ideologia)
	@Override
	public List<PartidoDTO> listarPorIdeologia(String ideologia) {
		List<PartidoDTO> partido = new ArrayList<>();
		if(ideologia != null) {
			partido = this.repository.findByIdeologia(ideologia).stream().map(s -> mapper.map(s, PartidoDTO.class)).collect(Collectors.toList());
			
		}
		return partido;
	}

	
	//GET - /partidos/{id}/associados (Listar todos os associados daquele partido)
	@Override
	public PartidoDTO listarAssociados(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//GET - /partidos/{id}
	@Override
	public PartidoDTO detalhar(Long id) {
		Optional<Partido> partido = repository.findById(id);
		if (partido.isPresent()) {
			return mapper.map(partido.get(), PartidoDTO.class);
		}
		throw new RuntimeException("Partido não está presente");
	}

	
	//PUT - /partidos/{id}
	@Override
	public PartidoDTO atualizar(Long id, PartidoFormDTO body) {
		Optional<Partido> partido = this.repository.findById(id);
        if (partido.isPresent() == true) {
        	partido.get().setNomePartido(body.getNomePartido());
        	partido.get().setSigla(body.getSigla());
        	partido.get().setIdeologia(body.getIdeologia());
        	partido.get().setDataFundacao(body.getDataFundacao());
        	Partido st = this.repository.save(partido.get());
            return mapper.map(st, PartidoDTO.class);
        }
        throw new RuntimeException("Estado não encontrado");
	}

	
	//DELETE - /partidos/{id}
	@Override
	public void remover(Long id) {
		Optional<Partido> optional = this.repository.findById(id);
		if (optional.isPresent()) {
			this.repository.deleteById(id);
		}else {
			throw new RuntimeException("Estado não encontrado");
		}
		
	}

}
