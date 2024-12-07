package br.com.loggest.model.dao;

import br.com.loggest.model.dao.impl.AdministradorDAOImpl;
import br.com.loggest.model.dao.impl.MotoristaDAOImpl;
import br.com.loggest.model.dao.impl.OrdemMissaoDAOImpl;
import br.com.loggest.model.dao.impl.VeiculoDAOImpl;

public class DAOFactory {
    public static VeiculoDAO createVeiculoDAO(){
        return new VeiculoDAOImpl();
    }

    public static MotoristaDAO createMotoristaDAO(){
        return new MotoristaDAOImpl();
    }

    public static OrdemMissaoDAO createOrdemMissaoDAO(){
        return new OrdemMissaoDAOImpl();
    }
    public static AdministradorDAO createAdministradorDAO(){
        return new AdministradorDAOImpl();
    }
}
