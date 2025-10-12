package br.com.loggest.model.entities;

import br.com.loggest.model.entities.enuns.TipoContato;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TAB_CONTATOS")
public class Contato implements Serializable {

    private static final long serialVersionUID=1l;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_CONTATO")
    private TipoContato tipoContato;
    @Column(name = "DDD")
    private Integer ddd;
    @Column(name = "NUMERO")
    private Integer numero;
    @Column(name = "VERIFICADO")
    private Boolean verificado;
    @Column(name = "AUTORIZA")
    private Boolean autoriza;
    @ManyToOne
    @JoinColumn(name = "FK_PESSOAS", referencedColumnName = "ID")
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public Boolean getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(Boolean autoriza) {
        this.autoriza = autoriza;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
