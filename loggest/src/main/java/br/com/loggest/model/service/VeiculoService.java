package br.com.loggest.model.service;

import br.com.loggest.model.dao.DAOFactory;
import br.com.loggest.model.dao.VeiculoDAO;
import br.com.loggest.model.entities.Veiculo;

import java.util.List;

public class VeiculoService {

    private final VeiculoDAO dao = DAOFactory.createVeiculoDAO();

    public List<Veiculo> findAll(){
        return dao.findAll();
    }

    public void saveOrUpdate(Veiculo obj){
        if(obj.getId_veiculo() == null){
            dao.create(obj);
        }else{
            dao.update(obj);
        }
    }

    public void remove(Veiculo obj){
        dao.deleteById(obj.getId_veiculo());
    }
}
