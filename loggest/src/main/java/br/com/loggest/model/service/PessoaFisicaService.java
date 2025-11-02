package br.com.loggest.model.service;

import br.com.loggest.model.dao.PessoaDAO;
import br.com.loggest.model.dao.PessoaFisicaDAO;
import br.com.loggest.model.entities.Pessoa;
import br.com.loggest.model.entities.PessoaFisica;
import br.com.loggest.model.factory.PessoaFactory;
import br.com.loggest.model.factory.PessoaFisicaFactory;
import br.com.loggest.model.util.ConfigConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class PessoaFisicaService {

    public final PessoaFisicaDAO pessoaFisicaDAO = PessoaFisicaFactory.createPessoaFisicaDAO();
    public final PessoaDAO pessoaDAO = PessoaFactory.createPessoaDAO();

    public void salvarPessoaFisica(PessoaFisica obj){
        Connection con = null;
        try {
            if(obj.getId() == null){
                con = ConfigConnectionDB.connect();
                con.setAutoCommit(false);
                pessoaDAO.criarPessoaFisica(obj, con);
                pessoaFisicaDAO.create(obj, con);
                con.commit();
            }
        }catch (SQLException e){
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

//    public void saveOrUpdate(PessoaFisica obj){
//        Connection con = null;
//        if(obj.getId() == null){
//            dao.create(obj);
//        }else{
//            dao.update(obj);
//        }
//    }
}
