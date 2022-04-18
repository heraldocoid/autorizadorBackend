package co.com.autorizador.web.ms.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.autorizador.web.ms.rest.modelo.TipoTarjeta;
import co.com.autorizador.web.ms.rest.response.GenericResponse;
import co.com.autorizador.web.ms.rest.service.TipoTarjetaService;

@RestController
@RequestMapping("/tipotarjeta")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class TipoTarjetaController {
	
	@Autowired
	private TipoTarjetaService service;
	
	
	@RequestMapping(value="/listarAll", method = RequestMethod.GET)
	public GenericResponse<List<TipoTarjeta>> list(){
	    GenericResponse<List<TipoTarjeta>> response = new GenericResponse<>();

	    try {
	        List<TipoTarjeta> all = service.list();
	        
	        response.setStatus(1);
	        response.setMessage("Consulta realizada satisfactoriamente.");
	        response.setValue(all);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("No se encontraron datos de representantes::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;
	}
	
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public GenericResponse<TipoTarjeta> create(@RequestBody TipoTarjeta request){
	    GenericResponse<TipoTarjeta> response = new GenericResponse<>();

	    try {
	        TipoTarjeta tipoTarjeta = service.create(request);
	        
	        response.setStatus(1);
	        response.setMessage("Se creo el tipo de tarjeta de manera satisfactoria.");
	        response.setValue(tipoTarjeta);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("No se encontraron datos de tipo de tarjeta::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;   
	}
	
	
	@RequestMapping(value="/listarid", method = RequestMethod.POST)
	public GenericResponse<Optional<TipoTarjeta>> create(@RequestBody int request){
	    GenericResponse<Optional<TipoTarjeta>> response = new GenericResponse<>();

	    try {
	        Optional<TipoTarjeta> one = service.listId(request);
	        
	        response.setStatus(1);
	        response.setMessage("Consulta realizada satisfactoriamente.");
	        response.setValue(one);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("No se encontraron datos de ::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;   
	}

}
