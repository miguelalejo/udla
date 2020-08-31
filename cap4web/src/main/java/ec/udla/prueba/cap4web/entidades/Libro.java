package ec.udla.prueba.cap4web.entidades;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Libro {
	private String id;
	@NotBlank
	private String autor;
	@NotNull
	private Integer anio;

	public Libro() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

}
