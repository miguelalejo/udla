package ec.udla.prueba.cap4web.productor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.udla.prueba.cap4web.entidades.Libro;
import ec.udla.prueba.cap4web.manejador.error.ManejadorError;
import ec.udla.prueba.cap4web.repositorios.RepositorioLibro;

@RestController
@RequestMapping("/libro")
public class ProductorRestLibro {
	@Autowired
	private RepositorioLibro repositorioLibro;

	@PostMapping("/guardar")
	public @ResponseBody ResponseEntity<String> guardarLibro(@RequestBody Libro libro) {
		Libro libroEntidad = repositorioLibro.guardar(libro);
		return new ResponseEntity<String>(libroEntidad.getId(), HttpStatus.CREATED);
	}

	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Libro>> listarLibros() {
		List<Libro> libros = repositorioLibro.obtenerTodos();
		return new ResponseEntity<List<Libro>>(libros, HttpStatus.CREATED);
	}

	@RequestMapping("/buscar")
	public @ResponseBody ResponseEntity<Libro> buscarLibro(@RequestParam String id) {
		Libro libro = repositorioLibro.obtenerPorId(id);
		return new ResponseEntity<Libro>(libro, HttpStatus.CREATED);
	}

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ManejadorError handleException(Exception exception) {
		return new ManejadorError(exception.getMessage());
	}
}
