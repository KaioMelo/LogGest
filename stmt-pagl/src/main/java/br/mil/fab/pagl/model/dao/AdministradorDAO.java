package br.mil.fab.pagl.model.dao;

import br.mil.fab.pagl.model.entities.Administrador;

public interface AdministradorDAO {
    void create (Administrador obj);
    void update (Administrador obj);
    boolean getAllAdmin(Administrador obj);
}
