package ec.com.udla.prueba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import ec.com.udla.prueba.entidades.Alumno;
import ec.com.udla.prueba.repositorio.RepositorioAlumno;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositorioServiceAlumnoTest {

	@Autowired
	RepositorioAlumno repositorioAlumno;

	@BeforeEach
	public void configuarPersona() {
		Alumno alumno = new Alumno();
		alumno.setNombre("Miguel");
		alumno.setCurso("3roA");
		alumno.setFactultad("INFORMÁTICA");
		repositorioAlumno.save(alumno);
		Alumno alumnoMiguel = new Alumno();
		alumnoMiguel.setNombre("Miguel");
		alumnoMiguel.setCurso("4roA");
		alumnoMiguel.setFactultad("FÍSICA");
		repositorioAlumno.save(alumnoMiguel);
		Alumno alumnoMichel = new Alumno();
		alumnoMichel.setNombre("Michel");
		alumnoMichel.setCurso("8voC");
		alumnoMichel.setFactultad("ADMINISTRACIÓN");
		repositorioAlumno.save(alumnoMichel);
	}

	@Test
	public void deberiaCargarRepostiorio() {
		assertThat(repositorioAlumno).isNotNull();
	}

	@Test
	public void deberiaGuardarAlumno() {
		Alumno alumno = new Alumno();
		alumno.setNombre("Mia");
		Alumno personaActual = repositorioAlumno.save(alumno);
		assertThat(alumno.getId()).isEqualTo(personaActual.getId());
	}

	@Test
	public void deberiaModifcarAlumno() {
		Alumno alumno = new Alumno();
		alumno.setId("7fd921cfd2b64dc7b995633e8209f385");
		alumno.setNombre("Miguel");
		Alumno alumnoActual = repositorioAlumno.save(alumno);
		assertThat(alumno.getNombre()).isEqualTo(alumnoActual.getNombre());
	}

	@Test
	public void deberiaVerificarAlumnosRegistrados() {
		List<String> listaIds = new ArrayList<String>();
		listaIds.add("7fd921cfd2b64dc7b995633e8209f385");
		listaIds.add("7fd921cfd2b64dc7b995633e8209f386");
		List<Alumno> listaAlumnos = repositorioAlumno.findAll();
		int contador = 0;
		for (String id : listaIds) {
			for (Alumno alumno : listaAlumnos) {
				if (alumno.getId().equals(id)) {
					contador++;
				}
			}
		}
		assertThat(2).isEqualTo(contador);

	}

	@Test
	public void deberiaBuscarPersona() {
		Optional<Alumno> alumno = repositorioAlumno.findById("7fd921cfd2b64dc7b995633e8209f385");
		assertTrue(alumno.isPresent());
	}

	@Test
	public void deberiaBuscarPersonaPorFacultad() {
		List<Alumno> personas = repositorioAlumno.buscarPorFactultad("MATEMÁTICA");
		for (Alumno alumno : personas) {
			assertThat(alumno.getNombre()).isEqualTo("Miguel");
		}

	}

}
