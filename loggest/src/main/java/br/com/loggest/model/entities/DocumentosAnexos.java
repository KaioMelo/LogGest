package br.com.loggest.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TAB_DOCUMENTOS_ANEXOS")
public class DocumentosAnexos {

    @Id
    @Column(name = "CODIGO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "FK_TIPO_ARQUIVO")
    private Long tipoArquivo;

    @Column(name = "SITUACAO")
    private boolean situacao;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(Long tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}
