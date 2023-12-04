package br.mil.fab.pagl.model;

public class Militar extends Motorista{
    private String nome_militar;
    private String om;
    private String sessao;
    private Integer saram;

    public Militar() {
    }

    public Militar(Integer id_motorista, Integer cnh, String nome_militar, String om, String sessao, Integer saram) {
        super(id_motorista, cnh);
        this.nome_militar = nome_militar;
        this.om = om;
        this.sessao = sessao;
        this.saram = saram;
    }

    public String getNome_militar() {
        return nome_militar;
    }

    public void setNome_militar(String nome_militar) {
        this.nome_militar = nome_militar;
    }

    public String getOm() {
        return om;
    }

    public void setOm(String om) {
        this.om = om;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public Integer getSaram() {
        return saram;
    }

    public void setSaram(Integer saram) {
        this.saram = saram;
    }
}
