package br.com.loggest.model.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
@Entity
@Table(name = "CAD_MOTORISTAS")
public class Motorista extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CNH")
    private Integer cnh;
    @Column(name = "VENCIMENTO_CNH")
    private Calendar vencimentoCnh;
    @Column(name = "FK_CAD_PESSOA")
    private Pessoa pessoa;
    @Column(name = "FK_CAD_TOXICOLOGICOS")
    private Toxicologico toxicologico;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCnh() {
        return cnh;
    }

    public void setCnh(Integer cnh) {
        this.cnh = cnh;
    }

    public Calendar getVencimentoCnh() {
        return vencimentoCnh;
    }

    public void setVencimentoCnh(Calendar vencimentoCnh) {
        this.vencimentoCnh = vencimentoCnh;
    }

    public Toxicologico getToxicologico() {
        return toxicologico;
    }

    public void setToxicologico(Toxicologico toxicologico) {
        this.toxicologico = toxicologico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(id, motorista.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
