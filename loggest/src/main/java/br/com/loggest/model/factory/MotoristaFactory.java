package br.com.loggest.model.factory;

import br.com.loggest.model.dao.MotoristaDAO;
import br.com.loggest.model.dao.MotoristaDAOImpl;

public class MotoristaFactory {
    public static MotoristaDAO createMotoristaDAO(){
        return new MotoristaDAOImpl();
    }
}
