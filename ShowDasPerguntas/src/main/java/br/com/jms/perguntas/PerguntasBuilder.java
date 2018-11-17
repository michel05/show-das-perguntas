package br.com.jms.perguntas;

import java.util.ArrayList;

import br.com.jms.enums.CategoriaPerguntas;
import br.com.jms.model.Pergunta;
import br.com.jms.model.Resposta;
import lombok.experimental.UtilityClass;


@UtilityClass
public class PerguntasBuilder {

	public Pergunta constroiPergunta(CategoriaPerguntas categoriaPergunta) {

		Pergunta pergunta = null;
		switch (categoriaPergunta) {
		case ATUALIDADES:
			pergunta = constroiPerguntaAtualizadade();
			break;
		case FUTEBOL:
			pergunta = constroiPerguntaFutebol();
			break;
		case GEOGRAFIA:
			pergunta = constroiPerguntaGeografia();
			break;
		case HISTORIA:
			pergunta = constroiPerguntaHistoria();
			break;
		}
		
		return pergunta;
	}
	
	
	private Pergunta constroiPerguntaFutebol() {
		Pergunta pergunta = new Pergunta();
		pergunta.setDescricao("Quais foram os primeiros jogadores bicampeões mundiais?");
		pergunta.setRespostas(new ArrayList<Resposta>());
		pergunta.getRespostas().add(new Resposta("a) Giuseppe Meazza e Giovanni Ferrari", true));
		pergunta.getRespostas().add(new Resposta("b) Pelé e Garrincha", false));
		pergunta.getRespostas().add(new Resposta("c) Gilmar e Nilton Santos", false));
		pergunta.getRespostas().add(new Resposta("d) Juan Schiaffino e José Leandro Andrade", false));
		pergunta.getRespostas().add(new Resposta("e) Silvio Piola e Giuseppe Meazza", false));
		
		return pergunta;
	}
	
	private Pergunta constroiPerguntaGeografia() {
		Pergunta pergunta = new Pergunta();
		pergunta.setDescricao("Qual desses não é ilha?");
		pergunta.setRespostas(new ArrayList<Resposta>());
		pergunta.getRespostas().add(new Resposta("a) Madagasgar", false));
		pergunta.getRespostas().add(new Resposta("b) Indonesia", false));
		pergunta.getRespostas().add(new Resposta("c) Barbados", false));
		pergunta.getRespostas().add(new Resposta("d) Bermudas", false));
		pergunta.getRespostas().add(new Resposta("e) Libia", true));
		
		return pergunta;
	}
	
	private Pergunta constroiPerguntaHistoria() {
		Pergunta pergunta = new Pergunta();
		pergunta.setDescricao("'Cinquenta anos em cinco' foi o bordão de qual popular presidente?");
		pergunta.setRespostas(new ArrayList<Resposta>());
		pergunta.getRespostas().add(new Resposta("a) Jânio Quadros", false));
		pergunta.getRespostas().add(new Resposta("b) Juscelino Kubitschek", true));
		pergunta.getRespostas().add(new Resposta("c) Ranieri Mazzilli", false));
		pergunta.getRespostas().add(new Resposta("d) Ernesto Geisel", false));
		pergunta.getRespostas().add(new Resposta("e) Fernando Collor", false));
		
		return pergunta;
	}


	private Pergunta constroiPerguntaAtualizadade() {
		Pergunta pergunta = new Pergunta();
		pergunta.setDescricao("Qual das alternativas traz uma das medidas do presidente Trump que causaram polêmica?");
		pergunta.setRespostas(new ArrayList<Resposta>());
		pergunta.getRespostas().add(new Resposta("a) Construção de um muro na fronteira com o Canadá", false));
		pergunta.getRespostas().add(new Resposta("b) Cessação de Acordo de Comércio Livre (ACL) entre os Estados Unidos e Israel", false));
		pergunta.getRespostas().add(new Resposta("c) Saída do Acordo de Paris", false));
		pergunta.getRespostas().add(new Resposta("d) Saída da OTAN - Organização do Tratado do Atlântico Norte", true));
		pergunta.getRespostas().add(new Resposta("e) Reconciliação dos EUA com Cuba", false));
		
		return pergunta;
	}
}
