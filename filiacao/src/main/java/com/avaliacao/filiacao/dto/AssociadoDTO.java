package com.avaliacao.filiacao.dto;

import java.time.LocalDate;

import com.avaliacao.filiacao.entity.Partido;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AssociadoDTO {

	private long id;
	private String nome;
	private String cargoPolitico;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-03")
	private LocalDate dataNacimento;
	private String sexo;
	private Partido partido;
}
