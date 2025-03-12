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
    @Column(name = "FK_TAD_STATUS")
    private Long status;
    @Column(name = "IDENTIFICADOR")
    private String identificador;
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "FK_TAB_PESSOA")
    private Pessoa pessoa;
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
    @Column(name = "FK_TAD_NATUREZA")
    private Long natureza;
}
