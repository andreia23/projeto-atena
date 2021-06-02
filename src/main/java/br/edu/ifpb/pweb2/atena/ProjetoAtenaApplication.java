package br.edu.ifpb.pweb2.atena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ProjetoAtenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAtenaApplication.class, args);
	}

}
