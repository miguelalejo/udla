package ec.udla.prueba.cap4web.repositorios;

import java.util.List;

public interface RepositorioBase<T> {
	public T guardar(T domain);

	public T obtenerPorId(String id);

	public List<T> obtenerTodos();

}
