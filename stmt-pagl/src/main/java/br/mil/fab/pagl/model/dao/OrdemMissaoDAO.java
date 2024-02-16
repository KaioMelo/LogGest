package br.mil.fab.pagl.model.dao;


import br.mil.fab.pagl.model.entities.OrdemMissao;

import java.util.List;

public interface OrdemMissaoDAO {
    void create (OrdemMissao obj);
    void update (OrdemMissao obj);
    void deleteById(Integer id);
    List<OrdemMissao> findAll();
}
