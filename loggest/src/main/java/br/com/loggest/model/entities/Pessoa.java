package br.com.loggest.model.entities;

import br.com.loggest.model.entities.enuns.TipoFuncaoPessoa;
import br.com.loggest.model.entities.enuns.TipoPessoa;
import br.com.loggest.model.entities.enuns.TipoSexo;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TAB_PESSOAS")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private TipoSexo tipoSexo;
    private TipoPessoa tipoPessoa;
    private TipoFuncaoPessoa tipoFuncaoPessoa;
    private String senhaAnterior;
    private String senhaAtual;
    private String observacao;
    private List<DocumentosAnexos> documento;

    private List<Contato> contatos;

    private List<Email> emails;;

    private List<Endereco> enderecos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoSexo getTipoSexo() {
        return tipoSexo;
    }

    public void setTipoSexo(TipoSexo tipoSexo) {
        this.tipoSexo = tipoSexo;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public TipoFuncaoPessoa getTipoFuncaoPessoa() {
        return tipoFuncaoPessoa;
    }

    public void setTipoFuncaoPessoa(TipoFuncaoPessoa tipoFuncaoPessoa) {
        this.tipoFuncaoPessoa = tipoFuncaoPessoa;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getSenhaAnterior() {
        return senhaAnterior;
    }

    public void setSenhaAnterior(String senhaAnterior) {
        this.senhaAnterior = senhaAnterior;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoFuncaoPessoa getTipoPessoa() {
        return tipoFuncaoPessoa;
    }

    public void setTipoPessoa(TipoFuncaoPessoa tipoFuncaoPessoa) {
        this.tipoFuncaoPessoa = tipoFuncaoPessoa;
    }

    public List<DocumentosAnexos> getDocumento() {
        return documento;
    }

    public void setDocumento(List<DocumentosAnexos> documento) {
        this.documento = documento;
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
