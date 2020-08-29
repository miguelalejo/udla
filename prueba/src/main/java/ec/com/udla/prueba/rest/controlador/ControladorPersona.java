package ec.com.udla.prueba.rest.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.com.udla.prueba.entidades.Persona;
import ec.com.udla.prueba.repositorio.RepositorioPersona;

@RestController
@RequestMapping("/persona")
public class ControladorPersona {
	@Autowired
	private RepositorioPersona repositorioPersona;
	@RequestMapping("/")
	public @ResponseBody String saludo() {
		return "Hola";
	}

	@PostMapping("/agregar")
	public @ResponseBody ResponseEntity<Long> crearPersona(@RequestBody Persona persona) {	
		persona.setId(10L);
		repositorioPersona.save(persona);
		return new ResponseEntity<Long>(persona.getId(),HttpStatus.CREATED);
	}
	

}
