package br.mil.fab.pagl.dao;

import br.mil.fab.pagl.model.Motorista;

import java.util.List;

public interface MotoristaDAO {
    void create (Motorista obj);
    void update (Motorista obj);
    void deleteById(Integer id);
    void findById(Integer id);
    List<Motorista> findAll();
}
