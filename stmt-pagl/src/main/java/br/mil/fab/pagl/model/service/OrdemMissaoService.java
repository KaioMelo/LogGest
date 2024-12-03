package br.mil.fab.pagl.model.service;

import br.mil.fab.pagl.model.dao.DAOFactory;
import br.mil.fab.pagl.model.dao.OrdemMissaoDAO;
import br.mil.fab.pagl.model.entities.Viagens;

import java.util.List;

public class OrdemMissaoService {

    private final OrdemMissaoDAO dao = DAOFactory.createOrdemMissaoDAO();

    public List<Viagens> findAll(){
        return dao.findAll();
    }

    public void saveOrUpdate(Viagens obj){
        if(obj.getId_ordem() == null){
            dao.create(obj);
        }else{
            dao.update(obj);
        }
    }

    public void remove(Viagens obj){
        dao.deleteById(obj.getId_ordem());
    }
}
