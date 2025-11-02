package br.com.loggest.model.factory;

import br.com.loggest.model.dao.PessoaDAO;
import br.com.loggest.model.dao.PessoaDAOImpl;

public class PessoaFactory {
    public static PessoaDAO createPessoaDAO(){
        return new PessoaDAOImpl();
    }
}
