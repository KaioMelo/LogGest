package br.mil.fab.pagl.model.entities;

import java.util.Objects;

public class Administrador {

    private Integer id_adm;
    private String email;
    private String senha;

    public Administrador() {
    }

    public Administrador(Integer id_adm, String email, String senha) {
        this.id_adm = id_adm;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId_adm() {
        return id_adm;
    }

    public void setId_adm(Integer id_adm) {
        this.id_adm = id_adm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
