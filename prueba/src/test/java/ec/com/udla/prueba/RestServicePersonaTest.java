package ec.com.udla.prueba;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import ec.com.udla.prueba.entidades.Persona;
import ec.com.udla.prueba.rest.controlador.ControladorPersona;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestServicePersonaTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	ControladorPersona controladorPersona;

	@Test
	public void deberiaCargarControlador() {
		assertThat(controladorPersona).isNotNull();
	}	

	@Test
	public void deberiaSaludar() {
		assertThat(restTemplate.getForObject(String.format("http://localhost:%s/persona/", port), String.class))
				.contains("Hola");
	}

	@Test
	public void deberiaGuardarPersona() {
		Persona persona = new Persona();
		persona.setNombre("Miguel");
		persona.setEdad(33);
		ResponseEntity<Long> idPersona = restTemplate.postForEntity(String.format("http://localhost:%s/persona/agregar", port), persona, Long.class);
		assertThat(idPersona).isNotNull();		
	}
}
