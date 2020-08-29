package ec.com.udla.prueba.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.udla.prueba.entidades.Persona;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona,Long> {
	

}
