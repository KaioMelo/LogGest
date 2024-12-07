package br.com.loggest.model.dao;

import br.com.loggest.model.entities.Veiculo;

import java.util.List;

public interface VeiculoDAO {
    void create (Veiculo obj);
    void update (Veiculo obj);
    void deleteById(Integer rgFab);
    List<Veiculo> findAll();
}
