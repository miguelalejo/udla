package ec.com.udla.prueba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

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
		assertThat(persona).isEqualTo(personaActual);
	}
	
	@Test
	public void deberiaModifcarPersona() {
		Persona persona = new Persona();
		persona.setId(10L);
		persona.setNombre("Miguel");
		persona.setEdad(25);
		Persona personaActual = repositorioPersona.save(persona);
		assertThat(persona).isEqualTo(personaActual);
	}

	@Test
	public void deberiaBuscarPersona() {
		Optional<Persona> persona = repositorioPersona.findById(10L);
		assertTrue(persona.isPresent());
	}

}
