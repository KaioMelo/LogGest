package br.com.loggest.model.dao;

import br.com.loggest.model.entities.Pessoa;
import br.com.loggest.model.entities.PessoaFisica;

import java.sql.Connection;
import java.sql.SQLException;

public interface PessoaDAO {
    void criarPessoaFisica (PessoaFisica pessoa, Connection con) throws SQLException;
    void update (Pessoa pessoa);
}
