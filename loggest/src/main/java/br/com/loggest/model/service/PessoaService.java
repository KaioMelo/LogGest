package br.com.loggest.model.service;

import br.com.loggest.model.dao.PessoaDAO;
import br.com.loggest.model.entities.Pessoa;
import br.com.loggest.model.entities.PessoaFisica;
import br.com.loggest.model.factory.PessoaFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class PessoaService {

    public final PessoaDAO dao = PessoaFactory.createPessoaDAO();

    public void savePessoaFisica(PessoaFisica obj, Connection con) throws SQLException {
        if(obj.getId() == null){
            dao.criarPessoaFisica(obj, con);
        }
    }

//    public void saveOrUpdatePessoaFisica(PessoaFisica obj){
//        if(obj.getId() == null){
//            dao.createPessoaFisica(obj);
//        }else{
//            dao.update(obj);
//        }
//    }
}
