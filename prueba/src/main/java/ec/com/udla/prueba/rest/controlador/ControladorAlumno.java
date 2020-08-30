package ec.com.udla.prueba.rest.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.com.udla.prueba.entidades.Alumno;
import ec.com.udla.prueba.repositorio.RepositorioAlumno;

@RestController
@RequestMapping("/alumno")
public class ControladorAlumno {
	@Autowired
	private RepositorioAlumno repositorioAlumno;
	@RequestMapping("/")
	public @ResponseBody String saludo() {
		return "Hola";
	}

	@PostMapping("/agregar")
	public @ResponseBody ResponseEntity<Alumno> crearPersona(@RequestBody Alumno persona) {	
		Alumno alumnoRespuesta =repositorioAlumno.save(persona);
		return new ResponseEntity<Alumno>(alumnoRespuesta,HttpStatus.CREATED);
	}
	

}
