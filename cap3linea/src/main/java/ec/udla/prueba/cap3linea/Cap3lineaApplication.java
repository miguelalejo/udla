package ec.udla.prueba.cap3linea;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cap3lineaApplication implements CommandLineRunner {
	private final static Logger LOG = LoggerFactory.getLogger(Cap3lineaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Cap3lineaApplication.class, args);
	}

	@Autowired
	Date fechaServidor;

	@Bean
	public Date fechaServidor() {
		return new Date();
	}

	@Autowired
	ServicioConsulta servicioConsulta;

	@Override
	public void run(String... args) throws Exception {
		DateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		LOG.info(String.format("Hora servidor %s", formato.format(fechaServidor)));
		LOG.info(servicioConsulta.getNombreBase());

	}

}
