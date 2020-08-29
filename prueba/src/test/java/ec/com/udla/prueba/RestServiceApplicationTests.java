package ec.com.udla.prueba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import ec.com.udla.prueba.rest.controlador.ControladorSaludo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	ControladorSaludo controladorSaludo;

	@Test
	public void deberiaCargarControlador() {
		assertThat(controladorSaludo).isNotNull();
	}

	@Test
	public void deberiaSaludar() {
		assertThat(restTemplate.getForObject(String.format("http://localhost:%s/", port), String.class))
				.contains("Hola");
	}

	@Test
	public void deberiaDevolveListaItems() {
		List<String> itemsEsperados = new ArrayList<String>();
		itemsEsperados.add("Corona");
		itemsEsperados.add("Lapiz");
		itemsEsperados.add("Libros");
		String id = "1";
		@SuppressWarnings("unchecked")
		List<String> items = restTemplate.postForObject(String.format("http://localhost:%s/productos", port), id,
				ArrayList.class);
		assertIterableEquals(items, itemsEsperados);
	}

	@Test
	public void deberiaDevolveListaClientes() {
		List<String> clientes = new ArrayList<String>();
		clientes.add("Carlos");
		clientes.add("Miguel");
		String id = "1";
		@SuppressWarnings("unchecked")
		List<String> items = restTemplate.postForObject(String.format("http://localhost:%s/clientes?id=%s", port,id),
				id, ArrayList.class);
		assertIterableEquals(items, clientes);
	}
	
	

}
