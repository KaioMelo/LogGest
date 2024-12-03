package br.mil.fab.pagl.model.dao;


import br.mil.fab.pagl.model.entities.Viagens;

import java.util.List;

public interface OrdemMissaoDAO {
    void create (Viagens obj);
    void update (Viagens obj);
    void deleteById(Integer id);
    List<Viagens> findAll();
}
