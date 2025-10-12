package br.com.loggest.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "TAB_FUNCIONARIOS")
public class Funcionario implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "MATRICULA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer matricula;
    @OneToOne
    @JoinColumn(name = "FK_PESSOAS")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "FK_VENCIMENTOS")
    private Vencimentos vencimentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Vencimentos getVencimentos() {
        return vencimentos;
    }

    public void setVencimentos(Vencimentos vencimentos) {
        this.vencimentos = vencimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
