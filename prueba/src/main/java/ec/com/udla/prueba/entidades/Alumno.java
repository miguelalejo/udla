package ec.com.udla.prueba.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ALUMNO")
public class Alumno {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "CURSO")
	private String curso;
	@Column(name = "FACULTAD")
	private String factultad;
	@Column(name = "ESTADO")
	private boolean estado;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getFactultad() {
		return factultad;
	}

	public void setFactultad(String factultad) {
		this.factultad = factultad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
