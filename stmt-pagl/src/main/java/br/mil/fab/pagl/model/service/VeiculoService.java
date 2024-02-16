package br.mil.fab.pagl.model.service;

import br.mil.fab.pagl.model.dao.DAOFactory;
import br.mil.fab.pagl.model.dao.VeiculoDAO;
import br.mil.fab.pagl.model.entities.Veiculo;

import java.util.List;

public class VeiculoService {

    private VeiculoDAO dao = DAOFactory.createVeiculoDAO();

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
