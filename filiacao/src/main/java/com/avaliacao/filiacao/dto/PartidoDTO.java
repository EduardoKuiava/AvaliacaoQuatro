package com.avaliacao.filiacao.dto;

import java.time.LocalDate;
import java.util.List;

import com.avaliacao.filiacao.entity.Associado;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PartidoDTO {

	private long id;
	private String nomePartido;
	private String sigla;
	private String ideologia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-03")
	private LocalDate dataFundacao;
	private List<Associado> associados; 
}
