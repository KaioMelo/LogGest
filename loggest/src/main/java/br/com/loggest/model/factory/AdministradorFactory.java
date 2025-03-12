package br.com.loggest.model.factory;

import br.com.loggest.model.dao.AdministradorDAO;
import br.com.loggest.model.dao.AdministradorDAOImpl;

public class AdministradorFactory {
    public static AdministradorDAO createAdministradorDAO(){
        return new AdministradorDAOImpl();
    }
}
