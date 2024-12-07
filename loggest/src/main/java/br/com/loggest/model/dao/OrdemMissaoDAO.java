package br.com.loggest.model.dao;


import br.com.loggest.model.entities.Viagens;

import java.util.List;

public interface OrdemMissaoDAO {
    void create (Viagens obj);
    void update (Viagens obj);
    void deleteById(Integer id);
    List<Viagens> findAll();
}
