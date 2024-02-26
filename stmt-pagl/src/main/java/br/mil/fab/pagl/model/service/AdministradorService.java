package br.mil.fab.pagl.model.service;

import br.mil.fab.pagl.model.dao.AdministradorDAO;
import br.mil.fab.pagl.model.dao.DAOFactory;
import br.mil.fab.pagl.model.entities.Administrador;

public class AdministradorService {

    private AdministradorDAO dao = DAOFactory.createAdministradorDAO();

    public void saveOrUpdate(Administrador obj){
        if(obj.getId_adm() == null){
            dao.create(obj);
        }else{
            dao.update(obj);
        }
    }
    public void verificarLogin(Administrador obj){
        dao.getAllAdmin(obj);
    }
}
