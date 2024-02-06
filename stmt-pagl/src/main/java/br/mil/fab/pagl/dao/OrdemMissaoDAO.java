package br.mil.fab.pagl.dao;


import br.mil.fab.pagl.model.OrdemMissao;

import java.util.List;

public interface OrdemMissaoDAO {
    void create (OrdemMissao obj);
    void update (OrdemMissao obj);
    void deleteById(Integer id);
    List<OrdemMissao> findAll();
}
