package br.mil.fab.pagl.dao;

import br.mil.fab.pagl.model.Veiculo;

import java.util.List;

public interface VeiculoDAO {
    void create (Veiculo veiculo);
    void update (Veiculo veiculo);
    void deleteById(Veiculo veiculo);
    void findById(Integer id);
    List<Veiculo> findAll();
}
