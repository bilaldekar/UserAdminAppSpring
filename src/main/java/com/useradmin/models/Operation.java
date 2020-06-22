package com.useradmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
public class Operation {

    @Size(min = 0, max = 30)
    @Column
    private String name;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeAchat typeAchat;

    @ManyToOne
    @JoinColumn(name = "id_fournisseur", referencedColumnName = "id")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "id_facture", referencedColumnName = "id")
    private Facture facture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TypeAchat getTypeAchat() {
        return typeAchat;
    }

    public void setTypeAchat(TypeAchat typeAchat) {
        this.typeAchat = typeAchat;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
