package br.mil.fab.pagl.model;


import java.io.Serializable;
import java.util.Objects;

public class Motorista implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id_motorista;
    private String nome;
    private Integer cnh;
    private String carreira;
    private String om;
    private String sessao;

    public Motorista() {
    }

    public Motorista(Integer id_motorista, String nome, Integer cnh, String carreira, String om, String sessao) {
        this.id_motorista = id_motorista;
        this.nome = nome;
        this.cnh = cnh;
        this.carreira = carreira;
        this.om = om;
        this.sessao = sessao;
    }

    public Integer getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(Integer id_motorista) {
        this.id_motorista = id_motorista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCnh() {
        return cnh;
    }

    public void setCnh(Integer cnh) {
        this.cnh = cnh;
    }

    public String getCarreira() {
        return carreira;
    }

    public void setCarreira(String carreira) {
        this.carreira = carreira;
    }

    public String getOm() {
        return om;
    }

    public void setOm(String om) {
        this.om = om;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(id_motorista, motorista.id_motorista) && Objects.equals(cnh, motorista.cnh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_motorista, cnh);
    }
}
