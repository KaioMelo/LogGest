package br.mil.fab.pagl.model.entities;

import java.io.Serializable;
import java.util.Calendar;

public class Funcionario implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private Integer matricula;
    private String nome;
    private Integer rg;
    private String cpf;
    private String titulo;
    private String Pis;
    private Integer ctps;
    private Integer cnh;
    private Calendar vencimentoCnh;
    private Endereco endereco;
    private Vencimentos vencimentos;
    private Toxicologico toxicologico;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPis() {
        return Pis;
    }

    public void setPis(String pis) {
        Pis = pis;
    }

    public Integer getCtps() {
        return ctps;
    }

    public void setCtps(Integer ctps) {
        this.ctps = ctps;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Vencimentos getVencimentos() {
        return vencimentos;
    }

    public void setVencimentos(Vencimentos vencimentos) {
        this.vencimentos = vencimentos;
    }

    public Toxicologico getToxicologico() {
        return toxicologico;
    }

    public void setToxicologico(Toxicologico toxicologico) {
        this.toxicologico = toxicologico;
    }
}
