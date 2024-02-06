package br.mil.fab.pagl.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class OrdemMissao implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer id_ordem;
    private String solicitante;
    private String contato;
    private String destino;
    private String servico;
    private Date data;

    public OrdemMissao() {
    }

    public OrdemMissao(Integer id_ordem, String solicitante, String contato, String destino, String servico, Date data) {
        this.id_ordem = id_ordem;
        this.solicitante = solicitante;
        this.contato = contato;
        this.destino = destino;
        this.servico = servico;
        this.data = data;
    }

    public Integer getId_ordem() {
        return id_ordem;
    }

    public void setId_ordem(Integer id_ordem) {
        this.id_ordem = id_ordem;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
