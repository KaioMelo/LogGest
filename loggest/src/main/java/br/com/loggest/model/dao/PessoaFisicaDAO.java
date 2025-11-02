package br.com.loggest.model.dao;

import br.com.loggest.model.entities.PessoaFisica;

import java.sql.Connection;
import java.sql.SQLException;

public interface PessoaFisicaDAO {
    void create(PessoaFisica pessoaFisica, Connection con) throws SQLException;
    void update(PessoaFisica pessoaFisica);
}
