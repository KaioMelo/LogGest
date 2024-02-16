package br.mil.fab.pagl.model.dao;

import br.mil.fab.pagl.model.dao.impl.MotoristaDAOImpl;
import br.mil.fab.pagl.model.dao.impl.OrdemMissaoDAOImpl;
import br.mil.fab.pagl.model.dao.impl.VeiculoDAOImpl;

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
}
