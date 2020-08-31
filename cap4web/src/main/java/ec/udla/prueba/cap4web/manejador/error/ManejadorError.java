package ec.udla.prueba.cap4web.manejador.error;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ManejadorError {
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> errores = new ArrayList<>();
	private final String message;

	public ManejadorError(String mensaje) {
		this.message = mensaje;
	}

	public void addValidationError(String error) {
		errores.add(error);
	}

	public List<String> getErrors() {
		return errores;
	}

	public String getErrorMessage() {
		return message;
	}
}
