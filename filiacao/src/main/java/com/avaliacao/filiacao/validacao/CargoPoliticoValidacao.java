package com.avaliacao.filiacao.validacao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.avaliacao.filiacao.entity.Associado;
import com.avaliacao.filiacao.exception.CargoPoliticoException;

@Service
public class CargoPoliticoValidacao {
	
	private String v = "Vereador";
	private String pf = "Prefeito";
	private String de = "Deputado Estadual";
	private String df = "Deputado Federal";
	private String s = "Senador";
	private String g = "Governador";
	private String ps = "Presidente";
	private String n = "Nenhum";
	
	List<String> ListaCargoPolitico = Arrays.asList(v, pf, de, df, s, g, ps, n);
	
	public void validaCargoPolitico(Associado associado) {
		String x = associado.getCargoPolitico();
		if (!ListaCargoPolitico.contains(x)) {
			throw new CargoPoliticoException("Esse cargo político" + x + " não existe ou esta escrito de maneira incorreta");
		}
	}		
	
}
