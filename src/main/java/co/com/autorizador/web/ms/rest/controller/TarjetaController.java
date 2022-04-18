package co.com.autorizador.web.ms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.autorizador.web.ms.rest.modelo.Tarjeta;
import co.com.autorizador.web.ms.rest.response.GenericResponse;
import co.com.autorizador.web.ms.rest.service.TarjetaService;

@RestController
@RequestMapping("/tarjeta")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class TarjetaController {
	
	@Autowired
	private TarjetaService service;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public GenericResponse<List<Tarjeta>> list(){
	    GenericResponse<List<Tarjeta>> response = new GenericResponse<>();

	    try {
	        List<Tarjeta> all = service.list();
	        
	        response.setStatus(1);
	        response.setMessage("Consulta realizada satisfactoriamente.");
	        response.setValue(all);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("No se encontraron datos de tarjetas::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;
	}
	
	@RequestMapping(value="/tipotarjeta/{idtipotarjeta}/estado/{idestado}/crear", method = RequestMethod.POST)
	public GenericResponse<Tarjeta> create(@PathVariable("idtipotarjeta") int idTipTar, @PathVariable("idestado") int idEst, @RequestBody Tarjeta request){
	    GenericResponse<Tarjeta> response = new GenericResponse<>();

	    try {
	        Tarjeta created = service.create(idTipTar, idEst, request);
	        
	        response.setStatus(1);
	        response.setMessage("Se creo la tarjeta de manera satisfactoria.");
	        response.setValue(created);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("Se presento el siguiente inconveniente::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;   
	}
}
