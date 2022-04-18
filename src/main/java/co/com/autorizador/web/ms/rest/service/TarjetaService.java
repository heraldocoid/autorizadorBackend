package co.com.autorizador.web.ms.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.autorizador.web.ms.rest.exception.ResourceNotFoundException;
import co.com.autorizador.web.ms.rest.modelo.Tarjeta;
import co.com.autorizador.web.ms.rest.repository.EstadoRepository;
import co.com.autorizador.web.ms.rest.repository.TarjetaRepository;
import co.com.autorizador.web.ms.rest.repository.TipoTarjetaRepository;

@Service
public class TarjetaService {
	
	@Autowired
	private TipoTarjetaRepository tipoTarjetaRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private TarjetaRepository repository;
	
	
	public List<Tarjeta> list(){
		return (List<Tarjeta>) repository.findAll();
	}
	
	public Tarjeta create(int idTipTar, int idEst, Tarjeta tarjeta) {
		return tipoTarjetaRepository.findById(idTipTar).map(tipTar->{
			return estadoRepository.findById(idEst).map(est -> {
				tarjeta.setTipoTarjeta(tipTar);
				tarjeta.setEstado(est);
				return repository.save(tarjeta);
			}).orElseThrow( () -> new ResourceNotFoundException("El estado " +tarjeta.getEstado().getEstado()+ "no encontrado") );
		}).orElseThrow(() -> new ResourceNotFoundException("El tipo de tarajeta " +tarjeta.getTipoTarjeta().getTipoTarjeta()+ " no encontrado"));
	}
}
