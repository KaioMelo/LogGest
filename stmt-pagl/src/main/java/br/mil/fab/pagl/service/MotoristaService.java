package br.mil.fab.pagl.service;

import br.mil.fab.pagl.dao.DAOFactory;
import br.mil.fab.pagl.dao.MotoristaDAO;
import br.mil.fab.pagl.model.Motorista;

import java.util.List;

public class MotoristaService {

    private MotoristaDAO dao = DAOFactory.createMotoristaDAO();

    public List<Motorista> findAll(){
        return dao.findAll();
    }

    public void saveOrUpdate(Motorista obj){
        if(obj.getId_motorista() == null){
            dao.create(obj);
        }else{
            dao.update(obj);
        }
    }

    public void remove(Motorista obj){
        dao.deleteById(obj.getId_motorista());
    }
}
