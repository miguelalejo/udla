package ec.udla.prueba.cap4web.repositorios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ec.udla.prueba.cap4web.entidades.Libro;
import ec.udla.prueba.cap4web.expeciones.NoExisteLibro;

@Repository
public class RepositorioLibro implements RepositorioBase<Libro> {

	List<Libro> baseLibros = new ArrayList<Libro>();

	@Override
	public Libro guardar(Libro libro) {
		Libro libroEntidad = new Libro();
		libroEntidad.setAnio(libro.getAnio());
		libroEntidad.setAutor(libro.getAutor());
		baseLibros.add(libroEntidad);
		return libroEntidad;
	}

	@Override
	public Libro obtenerPorId(String id) {
		for (Libro libro : baseLibros) {
			if (libro.getId() == id) {
				return libro;
			}
		}
		throw new NoExisteLibro(String.format("No se encontro ningun libro para el Id %s", id));
	}

	@Override
	public List<Libro> obtenerTodos() {
		return baseLibros;
	}

}
