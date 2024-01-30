package br.mil.fab.pagl.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class OrdemMissao implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer id_ordem;
    private String soliciante;
    private String contato;
    private String destino;
    private String servico;
    private SimpleDateFormat data;
    private SimpleTimeZone hora;

    public OrdemMissao() {
    }

    public OrdemMissao(Integer id_ordem, String soliciante, String contato, String destino, String servico, SimpleDateFormat data, SimpleTimeZone hora) {
        this.id_ordem = id_ordem;
        this.soliciante = soliciante;
        this.contato = contato;
        this.destino = destino;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
    }

    public Integer getId_ordem() {
        return id_ordem;
    }

    public void setId_ordem(Integer id_ordem) {
        this.id_ordem = id_ordem;
    }

    public String getSoliciante() {
        return soliciante;
    }

    public void setSoliciante(String soliciante) {
        this.soliciante = soliciante;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public SimpleDateFormat getData() {
        return data;
    }

    public void setData(SimpleDateFormat data) {
        this.data = data;
    }

    public SimpleTimeZone getHora() {
        return hora;
    }

    public void setHora(SimpleTimeZone hora) {
        this.hora = hora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemMissao that = (OrdemMissao) o;
        return Objects.equals(id_ordem, that.id_ordem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ordem);
    }
}
