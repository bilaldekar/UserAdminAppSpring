package com.useradmin.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FactureProduit implements Serializable {

    @EmbeddedId
    protected FactureProduitPK factureProduitPK;

    @Column(name = "quantite")
    private Double quantite;

    @JoinColumn(name = "id_facture", referencedColumnName = "id",  insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Facture  facture;

    @JoinColumn(name = "id_produit", referencedColumnName = "id",  insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produit produit;



    public FactureProduit() {
    }

    public FactureProduitPK getFactureProduitPK() {
        return factureProduitPK;
    }

    public void setFactureProduitPK(FactureProduitPK factureProduitPK) {
        this.factureProduitPK = factureProduitPK;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    private void valider() {
        if (factureProduitPK == null) {
            factureProduitPK = new FactureProduitPK(facture.getId(), produit.getId());
        }
    }
}
