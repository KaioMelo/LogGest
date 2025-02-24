package br.com.loggest.model.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CAD_ADMINISTRADOR")
public class Administrador {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FK_CAD_EMAILS")
    private Email email;
    @Column(name = "FK_CAD_SENHAS")
    private Senhas senhas;
    @Column(name = "FK_CAD_FUNCIONARIOS")
    private Funcionario funcionario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Senhas getSenhas() {
        return senhas;
    }

    public void setSenhas(Senhas senhas) {
        this.senhas = senhas;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
