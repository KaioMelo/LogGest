package br.mil.fab.pagl.service;

import br.mil.fab.pagl.dao.DAOFactory;
import br.mil.fab.pagl.dao.MotoristaDAO;
import br.mil.fab.pagl.dao.OrdemMissaoDAO;
import br.mil.fab.pagl.model.Motorista;
import br.mil.fab.pagl.model.OrdemMissao;

import java.util.List;

public class OrdemMissaoService {

    private OrdemMissaoDAO dao = DAOFactory.createOrdemMissaoDAO();

    public List<OrdemMissao> findAll(){
        return dao.findAll();
    }

    public void saveOrUpdate(OrdemMissao obj){
        if(obj.getId_ordem() == null){
            dao.create(obj);
        }else{
            dao.update(obj);
        }
    }

    public void remove(OrdemMissao obj){
        dao.deleteById(obj.getId_ordem());
    }
}
