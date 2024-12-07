package br.com.loggest.model.dao;

import br.com.loggest.model.entities.Administrador;

public interface AdministradorDAO {
    void create (Administrador obj);
    void update (Administrador obj);
    boolean getAllAdmin(Administrador obj);
}
