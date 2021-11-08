package com.avaliacao.filiacao.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PartidoFormDTO {
	
	@NotNull @NotEmpty
	private String nomePartido;
	
	@NotNull @NotEmpty
	private String sigla;
	
	@NotNull @NotEmpty
	private String ideologia;
	
	@NotNull @NotEmpty
	private LocalDate dataFundacao;
}
