package ec.com.udla.prueba.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.com.udla.prueba.entidades.Alumno;


@Repository
public interface RepositorioAlumno extends JpaRepository<Alumno, String>{
	@Query("SELECT alu FROM Alumno alu WHERE facultad = ?1")
	public List<Alumno> buscarPorFactultad(String factuldad);
}
