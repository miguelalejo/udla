package ec.udla.prueba.cap3auto.rest;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@EnableAutoConfiguration(exclude = {ActiveMQAutoConfiguration.class})
@ComponentScan({ "ec.udla.prueba.cap3auto.rest"})
public class ProductorRestCliente {
	@RequestMapping("/saludo")
	public @ResponseBody String saludar() {
		return "Hola";
	}

	@RequestMapping("/saludo/nombre")
	public @ResponseBody String saludar(@RequestParam("nombre") String nombre) {
		return String.format("Hola %s buen día!!!", nombre);
	}

	@RequestMapping("/saludo/{nombre}/ingles")
	public @ResponseBody String saludarEnIngles(@PathVariable("nombre") String nombre) {
		return String.format("Hello %s how are you!!!", nombre);
	}

	@RequestMapping("/saludo/{nombre}/apellido/ingles")
	public @ResponseBody String saludarEnInglesConApellido(@PathVariable("nombre") String nombre,
			@RequestParam("apellido") String apellido) {
		return String.format("Hello %s %s how are you!!!", nombre, apellido);
	}

	public static void main(String[] args) {
		// SpringApplication.run(ProductorRestCliente.class, args);
		SpringApplication app = new SpringApplication(ProductorRestCliente.class);
		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.print("\n\n\tAPP PARA CLIENTES!\n\n".toUpperCase());
			}
		});
		app.run(args);
	}

}
