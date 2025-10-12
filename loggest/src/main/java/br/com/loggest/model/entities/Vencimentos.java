package br.com.loggest.model.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TAB_VENCIMENTOS")
public class Vencimentos {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FK_STATUS")
    private Long status;
    @Column(name = "IDENTIFICADOR")
    private String identificador;
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "DATA")
    private Date data;
    @Column(name = "VALOR_ORIGINAL")
    private BigDecimal valorOriginal;
    @Column(name = "JUROS")
    private BigDecimal juros;
    @Column(name = "MULTA")
    private BigDecimal multa;
    @Column(name = "VALOR_ATUAL")
    private BigDecimal valorAtual;
    @Column(name = "DATA_VENCIMENTO")
    private Date dataVencimento;
    @Column(name = "DATA_QUITACAO")
    private Date dataQuitacao;
    @Column(name = "DATA_PAGAMENTO")
    private Date dataPagamento;
    @Column(name = "FK_NATUREZA")
    private Long natureza;
    @ManyToOne
    @JoinColumn(name = "FK_PESSOAS", referencedColumnName = "ID")
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public BigDecimal getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(BigDecimal valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(Date dataQuitacao) {
        this.dataQuitacao = dataQuitacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Long getNatureza() {
        return natureza;
    }

    public void setNatureza(Long natureza) {
        this.natureza = natureza;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
