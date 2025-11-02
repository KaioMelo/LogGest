package br.com.loggest.model.factory;

import br.com.loggest.model.dao.PessoaFisicaDAO;
import br.com.loggest.model.dao.PessoaFisicaDAOImpl;

public class PessoaFisicaFactory {
    public static PessoaFisicaDAO createPessoaFisicaDAO (){
        return new PessoaFisicaDAOImpl();
    }
}
