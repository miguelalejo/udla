package ec.udla.prueba.cap3linea;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsulta {
	@Value("${db.nombre}")
	private String nombreBase;

	public String getNombreBase() {
		return nombreBase;
	}

	public void setNombreBase(String nombreBase) {
		this.nombreBase = nombreBase;
	}

}
