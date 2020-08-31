package ec.udla.prueba.cap3auto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import ec.udla.prueba.cap3auto.rest.ProductorRestCliente;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { ProductorRestCliente.class,
		TestConfiguration.class })
class Cap3AutoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	ProductorRestCliente productorRestCliente;

	@Test
	void cargarProductorRestCliente() {
		assertThat(productorRestCliente).isNotNull();
	}

	@Test
	void deberiaSaludar() {
		ResponseEntity<String> respuesta = restTemplate
				.getForEntity(String.format("http://localhost:%s/cliente/saludo", port), String.class);
		assertThat(respuesta.getBody()).isEqualTo("Hola");
	}

	@Test
	void deberiaSaludarNombre() {
		String nombre = "Ana";
		String url = String.format("http://localhost:%s/cliente/saludo/nombre", port);
		Map<String, String> urlParams = new HashMap<>();
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("nombre", nombre);
		ResponseEntity<String> respuesta = restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(),
				HttpMethod.GET, null, String.class);
		assertThat(respuesta.getBody()).isEqualTo("Hola Ana buen día!!!");
	}

	@Test
	void deberiaSaludarVariablePathNombre() {
		String nombre = "Ana";
		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("nombre", nombre);
		String url = String.format("http://localhost:%s/cliente/saludo/{nombre}/ingles", port);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		ResponseEntity<String> respuesta = restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(),
				HttpMethod.GET, null, String.class);
		assertThat(respuesta.getBody()).isEqualTo("Hello Ana how are you!!!");
	}

	@Test
	void deberiaSaludarVariablePathNombreConApellido() {
		String nombre = "Ana";
		String apellido = "Pasquel";
		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("nombre", nombre);
		String url = String.format("http://localhost:%s/cliente/saludo/{nombre}/apellido/ingles", port);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("apellido", apellido);
		ResponseEntity<String> respuesta = restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(),
				HttpMethod.GET, null, String.class);
		assertThat(respuesta.getBody()).isEqualTo("Hello Ana Pasquel how are you!!!");
	}

}
