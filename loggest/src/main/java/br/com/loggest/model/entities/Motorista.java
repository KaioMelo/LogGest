package br.com.loggest.model.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;
@Entity
@Table(name = "TAB_MOTORISTAS")
public class Motorista extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CNH")
    private Integer cnh;
    @Column(name = "VENCIMENTO_CNH")
    private Calendar vencimentoCnh;
    @Column(name = "FK_CAD_PESSOA")
    private Pessoa pessoa;
    @Column(name = "FK_CAD_DOCUMENTOS_ANEXOS")
    private DocumentosAnexos documentosAnexos;

    public Motorista(int id, int cnh, Date vencimentoCnh, Object pessoa, Object documentosAnexos) {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public DocumentosAnexos getDocumentosAnexos() {
        return documentosAnexos;
    }

    public void setDocumentosAnexos(DocumentosAnexos documentosAnexos) {
        this.documentosAnexos = documentosAnexos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(id, motorista.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
