package br.com.jms.respostas;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import br.com.jms.model.Pergunta;
import br.com.jms.model.Resposta;

@Component
public class RespostasController {

	@Value("${client.name}")
	private String client;

	@JmsListener(destination = "${jsa.activemq.queue.consumer}", containerFactory = "jsaFactory")
	@SendTo("${jsa.activemq.queue.producer.respostas}")
	public Message<Resposta> receive(Pergunta pergunta, @Header("solicitante") String solicitante) {

		System.out.println("\n\n########### Nova Pergunta de " + solicitante + " ###########");
		System.out.println(pergunta.getDescricao());
		pergunta.getRespostas().forEach(x -> System.out.println(x.getAlternativa()));

		Scanner scanner = new Scanner(System.in);
		int opcao = selecionaResposta(scanner);

		Resposta resposta = pergunta.getRespostas().get(opcao);
		resposta.setAlternativaEscolhida(true);
		System.out.println("Resposta " + (resposta.isCorreta() ? "Correta!" : "Errada!"));

		Message<Resposta> mesage = MessageBuilder.withPayload(resposta).setHeader("client", client).build();
		System.out.println("Resposta enviada para o servidor, aguarde novas perguntas...\n");
		return mesage;
	}

	private int selecionaResposta(Scanner scanner) {
		String resposta = scanner.nextLine();
		switch (resposta) {
		case "a":
			return 0;
		case "b":
			return 1;
		case "c":
			return 2;
		case "d":
			return 3;
		case "e":
			return 4;

		default:
			System.out.println("Opção Invalida");
			return selecionaResposta(scanner);
		}
	}
}