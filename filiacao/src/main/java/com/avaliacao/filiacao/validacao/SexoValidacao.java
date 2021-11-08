package com.avaliacao.filiacao.validacao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.avaliacao.filiacao.entity.Associado;
import com.avaliacao.filiacao.exception.SexoException;

@Service
public class SexoValidacao {
	
	private String m = "Direita";
	private String f = "Centro";

	
	List<String> ListaSexo = Arrays.asList(m, f);
	
	public void validaSexo(Associado associado) {
		String x = associado.getSexo();
		if (!ListaSexo.contains(x)) {
			throw new SexoException("A opção " + x + " não existe ou esta escrita de maneira incorreta");
		}
	}
}
