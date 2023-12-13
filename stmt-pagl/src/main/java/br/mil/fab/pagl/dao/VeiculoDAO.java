package br.mil.fab.pagl.dao;

import br.mil.fab.pagl.model.Veiculo;
import br.mil.fab.pagl.util.ConfigConnectionDB;

import java.util.List;

public interface VeiculoDAO {
    void create (Veiculo veiculo);
    void update (Veiculo veiculo);
    void deleteByRgFab(String rgFab);
    void findById(Integer id);
    List<Veiculo> findAll();
}
