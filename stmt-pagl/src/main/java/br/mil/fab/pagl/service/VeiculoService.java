package br.mil.fab.pagl.service;

import br.mil.fab.pagl.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    void create (Veiculo veiculo);
    void update (Veiculo veiculo);
    void deleteById(Integer id);
    void findById(Integer id);
    List<Veiculo> findAll();
}
