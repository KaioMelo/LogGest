package br.mil.fab.pagl.model.dao;

import br.mil.fab.pagl.model.entities.Motorista;

import java.util.List;

public interface MotoristaDAO {
    void create (Motorista obj);
    void update (Motorista obj);
    void deleteById(Integer id);
    List<Motorista> findAll();
}
