package br.com.loggest.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "TAB_VIAGENS")
public class Viagens implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "DATA_SAIDA")
    private Calendar dataSaida;
    @Column(name = "ORIGEM")
    private String origem;
    @Column(name = "DESTINO")
    private String destino;
    @Column(name = "KM_INICIO")
    private Integer kmInicio;
    @Column(name = "DATA_CHEGADA")
    private Calendar dataChegada;
    @Column(name = "KM_FINAL")
    private Integer kmFinal;
    @Column(name = "VALOR_FINAL")
    private Double valorFinal;
    @Column(name = "FK_VEICULOS")
    private Veiculo veiculo;
    @Column(name = "FK_MOTORISTAS")
    private Motorista motorista;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Calendar getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Calendar dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(Integer kmInicio) {
        this.kmInicio = kmInicio;
    }

    public Calendar getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Calendar dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Integer getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Integer kmFinal) {
        this.kmFinal = kmFinal;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viagens viagens = (Viagens) o;
        return Objects.equals(id, viagens.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
