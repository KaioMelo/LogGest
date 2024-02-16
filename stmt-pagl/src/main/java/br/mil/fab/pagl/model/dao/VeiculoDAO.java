package br.mil.fab.pagl.model.dao;

import br.mil.fab.pagl.model.entities.Veiculo;

import java.util.List;

public interface VeiculoDAO {
    void create (Veiculo obj);
    void update (Veiculo obj);
    void deleteById(Integer rgFab);
    List<Veiculo> findAll();
}
