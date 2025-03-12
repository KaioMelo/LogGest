package br.com.loggest.model.entities;

import br.com.loggest.model.entities.enuns.TipoPessoa;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TAB_PESSOAS")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FK_CAD_CONTATOS")
    private Contato contatos;
    @Column(name = "FK_CAD_EMAILS")
    private Email email;
    @Column(name = "FK_CAD_ENDERECOS")
    private Endereco endereco;
    @Column(name = "FK_CAD_TIPO_PESSOA")
    private TipoPessoa tipoPessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contato getContatos() {
        return contatos;
    }

    public void setContatos(Contato contatos) {
        this.contatos = contatos;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
