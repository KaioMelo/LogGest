package br.com.loggest.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TAB_SENHAS")
public class Senhas {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SENHA_ANTERIOR")
    private String senhaAnterior;

    @Column(name = "SENHA_NOVA")
    private String senhaNova;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Column(name = "FK_CAD_ADMINISTRADOR")
    private Administrador administrador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenhaAnterior() {
        return senhaAnterior;
    }

    public void setSenhaAnterior(String senhaAnterior) {
        this.senhaAnterior = senhaAnterior;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
