package br.mil.fab.pagl.dao;

import br.mil.fab.pagl.model.Veiculo;

import java.util.List;

public interface VeiculoDAO {
    void create (Veiculo obj);
    void update (Veiculo obj);
    void deleteById(Integer rgFab);
    void findById(Integer id);
    List<Veiculo> findAll();
}
