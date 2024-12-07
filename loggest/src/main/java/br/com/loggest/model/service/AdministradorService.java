package br.com.loggest.model.service;

import br.com.loggest.model.dao.AdministradorDAO;
import br.com.loggest.model.dao.DAOFactory;
import br.com.loggest.model.entities.Administrador;

public class AdministradorService {

    private final AdministradorDAO dao = DAOFactory.createAdministradorDAO();

    public void saveOrUpdate(Administrador obj){
        if(obj.getId_adm() == null){
            dao.create(obj);
        }else{
            dao.update(obj);
        }
    }
    public boolean verificarLogin(Administrador obj){
        return dao.getAllAdmin(obj);
    }
}
