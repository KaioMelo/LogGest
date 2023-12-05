package br.mil.fab.pagl.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class OrdemMissao implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer id_ordem;
    private SimpleDateFormat data;
    private String destino;
    private String servico;
    private String contato;
    private String combustivel;
    private String hodometro;
    private SimpleTimeZone hora;

    private Veiculo veiculo;
    private Motorista motorista;
    public OrdemMissao() {
    }

    public OrdemMissao(Integer id_ordem, SimpleDateFormat data, String destino,
                       String servico, String contato, String combustivel,
                       String hodometro, SimpleTimeZone hora) {
        this.id_ordem = id_ordem;
        this.data = data;
        this.destino = destino;
        this.servico = servico;
        this.contato = contato;
        this.combustivel = combustivel;
        this.hodometro = hodometro;
        this.hora = hora;
    }

    public Integer getId_ordem() {
        return id_ordem;
    }

    public void setId_ordem(Integer id_ordem) {
        this.id_ordem = id_ordem;
    }

    public SimpleDateFormat getData() {
        return data;
    }


    public void setData(SimpleDateFormat data) {
        this.data = data;
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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getHodometro() {
        return hodometro;
    }

    public void setHodometro(String hodometro) {
        this.hodometro = hodometro;
    }

    public SimpleTimeZone getHora() {
        return hora;
    }

    public void setHora(SimpleTimeZone hora) {
        this.hora = hora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
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
