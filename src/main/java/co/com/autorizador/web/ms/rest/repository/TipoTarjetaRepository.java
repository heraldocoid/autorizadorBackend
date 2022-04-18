package co.com.autorizador.web.ms.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.autorizador.web.ms.rest.modelo.TipoTarjeta;

@Repository
public interface TipoTarjetaRepository extends CrudRepository<TipoTarjeta, Integer>{

}
