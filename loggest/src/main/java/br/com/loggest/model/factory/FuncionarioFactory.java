package br.com.loggest.model.factory;

import br.com.loggest.model.dao.FuncionarioDAO;
import br.com.loggest.model.dao.FuncionarioDAOImpl;

public class FuncionarioFactory {
    public static FuncionarioDAO createAdministradorDAO(){
        return new FuncionarioDAOImpl();
    }
}
