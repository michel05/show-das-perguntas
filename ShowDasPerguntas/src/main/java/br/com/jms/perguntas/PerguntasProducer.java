package br.com.jms.perguntas;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import br.com.jms.enums.CategoriaPerguntas;
import br.com.jms.model.Pergunta;


@Component
public class PerguntasProducer {

	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jsa.activemq.queue.producer}")
	String queueProducer;
	
	/**
	 * Recebe a categoria. monta e envia a pergunta para a lista no servidor do ActiveMQ
	 * @param categoriaPerguntas
	 * @throws JMSException
	 */
	public void pushPerguntas(CategoriaPerguntas categoriaPerguntas) throws JMSException {
		Pergunta pergunta = PerguntasBuilder.constroiPergunta(categoriaPerguntas);
		
		jmsTemplate.convertAndSend(queueProducer, pergunta, new MessagePostProcessor() {
	        public Message postProcessMessage(Message message) throws JMSException {
	            message.setStringProperty("solicitante", "Marconi Braga");
	            return message;
	        }
	    });
	}
}
