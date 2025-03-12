package br.com.loggest.model.service;

import br.com.loggest.model.dao.AdministradorDAO;
import br.com.loggest.model.entities.Administrador;
import br.com.loggest.model.factory.AdministradorFactory;

public class AdministradorService {

   public final AdministradorDAO dao = AdministradorFactory.createAdministradorDAO();

    public void saveOrUpdate(Administrador obj){
        if(obj.getId() == null){
            dao.create(obj);
        }else{
            dao.update(obj);
        }
    }
    public boolean verificarLogin(Administrador obj){
        return dao.getAllAdmin(obj);
    }
}
