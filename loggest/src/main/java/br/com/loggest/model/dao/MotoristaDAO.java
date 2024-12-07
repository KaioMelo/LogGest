package br.com.loggest.model.dao;

import br.com.loggest.model.entities.Motorista;

import java.util.List;

public interface MotoristaDAO {
    void create (Motorista obj);
    void update (Motorista obj);
    void deleteById(Integer id);
    List<Motorista> findAll();
}
