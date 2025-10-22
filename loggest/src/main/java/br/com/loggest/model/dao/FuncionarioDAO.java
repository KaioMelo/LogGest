package br.com.loggest.model.dao;

import br.com.loggest.model.entities.Pessoa;

public interface FuncionarioDAO {
    void create (Pessoa obj);
    void update (Pessoa obj);
    boolean getLogin(String matricula, String senha);
}
