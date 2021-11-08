package com.avaliacao.filiacao.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Partido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePartido;
	private String sigla;
	private String ideologia;
	private LocalDate dataFundacao;
	
	@OneToMany
	private List<Associado> associados; 
}
