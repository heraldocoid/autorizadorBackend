package co.com.autorizador.web.ms.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.autorizador.web.ms.rest.exception.ResourceNotFoundException;
import co.com.autorizador.web.ms.rest.modelo.TipoTarjeta;
import co.com.autorizador.web.ms.rest.repository.TipoTarjetaRepository;

@Service
public class TipoTarjetaService {
	
	@Autowired
	private TipoTarjetaRepository repository;
	
	public Optional<TipoTarjeta> listId(int id) {
		return repository.findById(id);
	}
	
	public List<TipoTarjeta> list() {
		return (List<TipoTarjeta>) repository.findAll();
	}
	
	public TipoTarjeta create(TipoTarjeta tipoTarjeta) {
		return repository.save(tipoTarjeta);
	}
	
	public TipoTarjeta update(TipoTarjeta tipoTarjeta, int id) {
		return repository.findById(id).map(tipTar->{
			tipoTarjeta.setTipoTarjeta(tipoTarjeta.getTipoTarjeta());
			return repository.save(tipoTarjeta);
		}).orElseThrow(()-> new ResourceNotFoundException("Tipo de tarjeta" + tipoTarjeta.getTipoTarjeta() + "no encontrado"));
	}
	
	
}
