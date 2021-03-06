package ec.com.udla.prueba.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.com.udla.prueba.entidades.Persona;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona,Long> {
	
	@Query("SELECT per FROM Persona per WHERE per.nombre = ?1 ")	
	public List<Persona> buscarPorNombre(String nombre);
}
