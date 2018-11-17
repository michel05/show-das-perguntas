package br.com.jms;

import java.util.Scanner;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

import br.com.jms.enums.CategoriaPerguntas;
import br.com.jms.perguntas.PerguntasProducer;

@SpringBootApplication
@EnableJms
@ComponentScan(basePackages = "br.com.jms.*")
public class ShowDasPerguntasApplication implements CommandLineRunner {

	@Autowired
	private PerguntasProducer perguntasProducer;

	public static void main(String[] args) {
		SpringApplication.run(ShowDasPerguntasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		mostraTelaPrincipal(scanner);
	}

	/**
	 * Tela principal
	 * 
	 * @param scanner
	 * @throws JMSException
	 */
	private void mostraTelaPrincipal(Scanner scanner) throws JMSException {
		System.out.println("########################   Show das Perguntas   ########################");
		System.out.println("Digite a categoria a ser enviada:");
		System.out.println("1 - Geografia");
		System.out.println("2 - Historia");
		System.out.println("3 - Futebol");
		System.out.println("4 - Atualidades\n");

		String opcao = scanner.nextLine();
		switch (opcao) {
		case "1":
			perguntasProducer.pushPerguntas(CategoriaPerguntas.GEOGRAFIA);
			break;
		case "2":
			perguntasProducer.pushPerguntas(CategoriaPerguntas.HISTORIA);
			break;
		case "3":
			perguntasProducer.pushPerguntas(CategoriaPerguntas.FUTEBOL);
			break;
		case "4":
			perguntasProducer.pushPerguntas(CategoriaPerguntas.ATUALIDADES);
			break;

		default:
			System.out.println("Opção inválida");
			break;
		}

		mostraTelaPrincipal(scanner);
	}
}
