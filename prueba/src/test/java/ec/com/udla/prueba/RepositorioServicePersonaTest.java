package ec.com.udla.prueba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import ec.com.udla.prueba.entidades.Persona;
import ec.com.udla.prueba.repositorio.RepositorioPersona;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositorioServicePersonaTest {

	@Autowired
	RepositorioPersona repositorioPersona;
	
	@BeforeEach
	public void configuarPersona() {
		Persona persona = new Persona();
		persona.setId(10L);
		persona.setNombre("Miguel");
		persona.setEdad(33);
		repositorioPersona.save(persona);
		Persona personaMiguel = new Persona();
		personaMiguel.setId(30L);
		personaMiguel.setNombre("Miguel");
		personaMiguel.setEdad(18);
		repositorioPersona.save(personaMiguel);
		Persona personaMichel = new Persona();
		personaMichel.setId(30L);
		personaMichel.setNombre("Michel");
		personaMichel.setEdad(20);
		repositorioPersona.save(personaMichel);
		
	}

	@Test
	public void deberiaCargarRepostiorio() {
		assertThat(repositorioPersona).isNotNull();
	}
	
	@Test
	public void deberiaGuardarPersona() {
		Persona persona = new Persona();
		persona.setId(11L);
		persona.setNombre("Mia");
		persona.setEdad(25);
		Persona personaActual = repositorioPersona.save(persona);
		assertThat(persona.getId()).isEqualTo(personaActual.getId());
	}
	
	@Test
	public void deberiaModifcarPersona() {
		Persona persona = new Persona();
		persona.setId(10L);
		persona.setNombre("Miguel");
		persona.setEdad(25);
		Persona personaActual = repositorioPersona.save(persona);
		assertThat(persona.getNombre()).isEqualTo(personaActual.getNombre());
	}

	@Test
	public void deberiaBuscarPersona() {
		Optional<Persona> persona = repositorioPersona.findById(10L);
		assertTrue(persona.isPresent());
	}
	
	@Test
	public void deberiaBuscarPersonaPorNombre() {
		List<Persona> personas = repositorioPersona.buscarPorNombre("Miguel");
		List<Integer> listaEdades = new ArrayList<Integer>();
		listaEdades.add(33);
		listaEdades.add(18);
		for(Persona persona: personas) {
			assertThat(persona.getNombre()).isEqualTo("Miguel");			
			assertThat(persona.getEdad(),in(listaEdades));
		}
		
	}


}
