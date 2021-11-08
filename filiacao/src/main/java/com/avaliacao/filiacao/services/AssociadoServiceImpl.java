package com.avaliacao.filiacao.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.filiacao.Repository.AssociadoRepository;
import com.avaliacao.filiacao.dto.AssociadoDTO;
import com.avaliacao.filiacao.dto.AssociadoFormDTO;
import com.avaliacao.filiacao.entity.Associado;
import com.avaliacao.filiacao.validacao.CargoPoliticoValidacao;
import com.avaliacao.filiacao.validacao.SexoValidacao;

@Service
public class AssociadoServiceImpl implements AssociadoService {

	@Autowired
	private AssociadoRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CargoPoliticoValidacao cargoPoliticoValidacao;
	
	@Autowired
	private SexoValidacao sexoValidacao;
	
	

	//POST - /associados
	@Override
	public AssociadoDTO salvar(AssociadoFormDTO body) {
		Associado associado = mapper.map(body, Associado.class);
		cargoPoliticoValidacao.validaCargoPolitico(associado);
		sexoValidacao.validaSexo(associado);
		Associado associadoResponse = this.repository.save(associado);
		return mapper.map(associadoResponse, AssociadoDTO.class);		
	}

	
	//POST - /associados/partidos (Vincula um associado a um partido, body: {idAssociado: '10', idPartido: '10'})
	@Override
	public AssociadoDTO Vincular(Long idAssociado, Long idPartido) {
		return null;
	}

	
	//GET - /associados (Ter uma opção de filtrar associados de acordo com seu cargo político)
	@Override
	public List<AssociadoDTO> listarPorCargo(String cargoPolitico) {
		List<AssociadoDTO> associado = new ArrayList<>();
		if(cargoPolitico != null) {
			associado = this.repository.findByCargoPolitico(cargoPolitico).stream().map(s -> mapper.map(s, AssociadoDTO.class)).collect(Collectors.toList());
			
		}
		return associado;
	}

	
	//GET - /associados/{id}
	@Override
	public AssociadoDTO detalhar(Long id) {
		Optional<Associado> associado = repository.findById(id);
		if (associado.isPresent()) {
			return mapper.map(associado.get(), AssociadoDTO.class);
		}
		throw new RuntimeException("Partido não está presente");
	}

	
	//PUT - /associados/{id}
	@Override
	public AssociadoDTO atualizar(Long id, AssociadoFormDTO body) {
		Optional<Associado> associado = this.repository.findById(id);
        if (associado.isPresent() == true) {
        	associado.get().setNome(body.getNome());
        	associado.get().setSexo(body.getSexo());
        	associado.get().setCargoPolitico(body.getCargoPolitico());
        	associado.get().setDataNacimento(body.getDataNacimento());
        	Associado st = this.repository.save(associado.get());
            return mapper.map(st, AssociadoDTO.class);
        }
        throw new RuntimeException("Estado não encontrado");
	}

	
	//DELETE - /associados/{id}
	@Override
	public void remover(Long id) {
		Optional<Associado> optional = this.repository.findById(id);
		if (optional.isPresent()) {
			this.repository.deleteById(id);
		}else {
			throw new RuntimeException("Estado não encontrado");
		}
	}

	
	//DELETE - /associados/{id}/partidos/{id} (Remove determinado associado daquele partido)
	@Override
	public void removerVinculado(Long ida, Long idp) {
		
	}

}
