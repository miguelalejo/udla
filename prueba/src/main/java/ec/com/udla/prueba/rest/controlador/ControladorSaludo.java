package ec.com.udla.prueba.rest.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ec.com.udla.prueba.ConfiguracionPropiedades;

@Controller
public class ControladorSaludo {
	@Autowired
	private ConfiguracionPropiedades configuracionPropiedades;
	
	@RequestMapping("/")
	public @ResponseBody String saludo() {
		return configuracionPropiedades.getSaludo();
	}

	@PostMapping("/productos")
	public @ResponseBody List<String> obtenerProductos(@RequestBody String id) {
		List<String> itemsEsperados = new ArrayList<String>();
		itemsEsperados.add("Corona");
		itemsEsperados.add("Lapiz");
		itemsEsperados.add("Libros");
		return itemsEsperados;
	}
	
	@PostMapping("/clientes")
	public @ResponseBody List<String> obtenerClietes(@RequestParam String id) {
		List<String> clientes = new ArrayList<String>();
		clientes.add("Carlos");
		clientes.add("Miguel");		
		return clientes;
	}
}
