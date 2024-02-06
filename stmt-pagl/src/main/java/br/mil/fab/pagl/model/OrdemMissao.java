package br.mil.fab.pagl.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class OrdemMissao implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer id_ordem;
    private String soliciante;
    private String contato;
    private String destino;
    private String servico;
    private LocalDate data;

    public OrdemMissao() {
    }

    public OrdemMissao(Integer id_ordem, String soliciante, String contato, String destino, String servico, LocalDate data) {
        this.id_ordem = id_ordem;
        this.soliciante = soliciante;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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
