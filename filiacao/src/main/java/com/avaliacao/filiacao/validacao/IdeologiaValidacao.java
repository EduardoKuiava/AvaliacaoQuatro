package com.avaliacao.filiacao.validacao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.avaliacao.filiacao.entity.Partido;
import com.avaliacao.filiacao.exception.IdeologiaException;

@Service
public class IdeologiaValidacao {
	
	private String d = "Direita";
	private String c = "Centro";
	private String e = "Esquerda";

	
	List<String> ListaIdeologia = Arrays.asList(d, c, e);
	
	public void validaIdeologia(Partido partido) {
		String x = partido.getIdeologia();
		if (!ListaIdeologia.contains(x)) {
			throw new IdeologiaException("Essa Ideologia " + x + " não existe ou esta escrita de maneira incorreta");
		}
	}		
}
