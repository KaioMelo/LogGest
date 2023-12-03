package br.mil.fab.pagl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Motorista implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_motorista;
    private Integer cnh;

    public Motorista() {
    }

    public Motorista(Integer id_motorista, Integer cnh) {
        this.id_motorista = id_motorista;
        this.cnh = cnh;
    }

    public Integer getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(Integer id_motorista) {
        this.id_motorista = id_motorista;
    }

    public Integer getCnh() {
        return cnh;
    }

    public void setCnh(Integer cnh) {
        this.cnh = cnh;
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
