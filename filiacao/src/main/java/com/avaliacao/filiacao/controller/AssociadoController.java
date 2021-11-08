package com.avaliacao.filiacao.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.filiacao.dto.AssociadoDTO;
import com.avaliacao.filiacao.dto.AssociadoFormDTO;
import com.avaliacao.filiacao.services.AssociadoService;

@RestController
@RequestMapping("/associados")
public class AssociadoController {
	
	@Autowired
	private AssociadoService service;
	
	//POST - /associados
	@PostMapping
	public ResponseEntity<AssociadoDTO> salvar(@RequestBody AssociadoFormDTO body){
		AssociadoDTO associado = this.service.salvar(body);
		return ResponseEntity.ok(associado);
	}
	
	//GET - /associados (Ter uma opção de filtrar associados de acordo com seu cargo político)
	@GetMapping
	public ResponseEntity<List<AssociadoDTO>> listarPorCargo(@RequestParam(value = "cargoPolitico", required = false) String cargoPolitico){
		return ResponseEntity.ok(this.service.listarPorCargo(cargoPolitico));
	}
	
	//GET - /partidos/{id}
	@GetMapping("/{id}")
	public ResponseEntity<AssociadoDTO> detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.detalhar(id));
	}
	
	//PUT - /partidos/{id}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AssociadoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AssociadoFormDTO body) {
		return ResponseEntity.ok(this.service.atualizar(id, body));
	}
	
	//DELETE - /partidos/{id}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		this.service.remover(id);
		return ResponseEntity.ok().build();
	}
	
	
	
}
