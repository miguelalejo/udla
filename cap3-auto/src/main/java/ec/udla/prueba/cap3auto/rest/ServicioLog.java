package ec.udla.prueba.cap3auto.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ServicioLog {
	private static final Logger LOG = LoggerFactory.getLogger(ServicioLog.class);

	@Autowired
	public ServicioLog(ApplicationArguments arguments) {		
		boolean esActivo = arguments.containsOption("activar");
		if(esActivo) {
			LOG.info("Log activo");
		}
		

	}

}
