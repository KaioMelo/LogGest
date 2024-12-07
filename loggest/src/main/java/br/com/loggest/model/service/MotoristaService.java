package br.com.loggest.model.service;

import br.com.loggest.model.dao.DAOFactory;
import br.com.loggest.model.dao.MotoristaDAO;
import br.com.loggest.model.entities.Motorista;

import java.util.List;

public class MotoristaService {

    private final MotoristaDAO dao = DAOFactory.createMotoristaDAO();

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
