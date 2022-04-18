package co.com.autorizador.web.ms.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.autorizador.web.ms.rest.modelo.Estado;
import co.com.autorizador.web.ms.rest.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> list(){
		return (List<Estado>) repository.findAll();
	}
	
	public Estado create(Estado estado) {
		return repository.save(estado);
	}
	
}
