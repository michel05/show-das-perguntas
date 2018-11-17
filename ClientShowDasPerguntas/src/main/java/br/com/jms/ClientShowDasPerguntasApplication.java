package br.com.jms;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.jms.*")
public class ClientShowDasPerguntasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientShowDasPerguntasApplication.class, args);
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		Scanner scanner = new Scanner(System.in);
//	}
}
