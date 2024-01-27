package br.mil.fab.pagl.model;

import java.util.Objects;

public class Administrador {

    private int id_adm;
    private String usuario;
    private String senha;

    public Administrador() {
    }

    public Administrador(int id_adm, String usuario, String senha) {
        this.id_adm = id_adm;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return id_adm == that.id_adm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_adm);
    }
}
