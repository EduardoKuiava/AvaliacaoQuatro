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

import com.avaliacao.filiacao.dto.PartidoDTO;
import com.avaliacao.filiacao.dto.PartidoFormDTO;
import com.avaliacao.filiacao.services.PartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

	
	@Autowired
	private PartidoService service;
	
	//POST - /partidos
	@PostMapping
	@Transactional
	public ResponseEntity<PartidoDTO> salvar(@RequestBody PartidoFormDTO body){
		PartidoDTO partido = this.service.salvar(body);
		return ResponseEntity.ok(partido);
	}
	
	//GET - /partidos (Ter uma opção de filtrar partidos de acordo com sua ideologia)
	@GetMapping
	public ResponseEntity<List<PartidoDTO>> listarPorIdeologia(@RequestParam(value = "Ideologia") String ideologia){
		return ResponseEntity.ok(this.service.listarPorIdeologia(ideologia));
	}
	
	//GET - /partidos/{id}
	@GetMapping("/{id}")
	public ResponseEntity<PartidoDTO> detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.detalhar(id));
	}
	
	//PUT - /partidos/{id}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PartidoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid PartidoFormDTO body) {
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
