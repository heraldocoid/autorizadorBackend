package co.com.autorizador.web.ms.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.autorizador.web.ms.rest.modelo.Tarjeta;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Integer>{

}
