package br.com.jms.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Pergunta implements Serializable {

	private static final long serialVersionUID = -7603670571906541766L;
	
	private String descricao;
	private List<Resposta> respostas;

}
