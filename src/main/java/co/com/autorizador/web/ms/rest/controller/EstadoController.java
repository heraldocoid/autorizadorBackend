package co.com.autorizador.web.ms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.autorizador.web.ms.rest.modelo.Estado;
import co.com.autorizador.web.ms.rest.response.GenericResponse;
import co.com.autorizador.web.ms.rest.service.EstadoService;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class EstadoController {
	
	@Autowired
	private EstadoService service;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public GenericResponse<List<Estado>> list(){
	    GenericResponse<List<Estado>> response = new GenericResponse<>();

	    try {
	        List<Estado> all = service.list();
	        
	        response.setStatus(1);
	        response.setMessage("Consulta realizada de manera satisfactoria.");
	        response.setValue(all);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("Se presento el siguiente inconveniente::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public GenericResponse<Estado> create(@RequestBody Estado request){
	    GenericResponse<Estado> response = new GenericResponse<>();

	    try {
	        Estado created = service.create(request);
	        
	        response.setStatus(1);
	        response.setMessage("Se creo el Estado de manera satisfactoria.");
	        response.setValue(created);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("Se presento el siguiente problema::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;   
	}
	
}
