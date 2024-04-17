package br.com.api.banco.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.banco.modelo.Conta;

@Repository
public interface ContaRepositorio extends CrudRepository<Conta, Long> {
    
}
