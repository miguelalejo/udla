package ec.com.udla.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PruebaApplication.class, args);		 
		SpringApplication app = new SpringApplication(PruebaApplication.class);
		//app.setDefaultProperties(Collections.singletonMap("server.port", "8084"));
		app.run(args);
	}

}
