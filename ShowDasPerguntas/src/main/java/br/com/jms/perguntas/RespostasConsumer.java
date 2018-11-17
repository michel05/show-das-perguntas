package br.com.jms.perguntas;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import br.com.jms.model.Resposta;

@Component
public class RespostasConsumer {

	@JmsListener(destination = "${jsa.activemq.queue.consumer.respostas}", containerFactory="jsaFactory")
	public void appleReceive(Resposta resposta, @Header("client") String client){
		System.out.println(client + " respondeu a pergunta, " + resposta.getAlternativa() + "\n\n");
	}
}
