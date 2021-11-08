package com.avaliacao.filiacao.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AssociadoFormDTO {

	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String cargoPolitico;
	
	@NotNull @NotEmpty
	private LocalDate dataNacimento;
	
	@NotNull @NotEmpty
	private String sexo;
}
