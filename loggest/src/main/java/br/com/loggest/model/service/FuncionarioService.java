package br.com.loggest.model.service;

import br.com.loggest.model.dao.FuncionarioDAO;
import br.com.loggest.model.entities.Pessoa;
import br.com.loggest.model.factory.FuncionarioFactory;

public class FuncionarioService {

   public final FuncionarioDAO dao = FuncionarioFactory.createAdministradorDAO();

    public void saveOrUpdate(Pessoa obj){
        if(obj.getId() == null){
            dao.create(obj);
        }else{
            dao.update(obj);
        }
    }
    public boolean verificarLogin(String matricula, String senha){
        return dao.getLogin(matricula, senha);
    }
}
