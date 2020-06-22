package com.useradmin.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

    @Embeddable
    public class FactureProduitPK implements Serializable {

        @Basic(optional = false)
        @NotNull
        @Column(name = "id_facture")
        private Long idFacture;

        @Basic(optional = false)
        @NotNull
        @Column(name = "id_produit")
        private Long idProduit;

        public FactureProduitPK() {
        }

        public FactureProduitPK( Long idFacture, Long idProduit) {
            this.idFacture = idFacture;
            this.idProduit = idProduit;
        }

        public Long getIdFacture() {
            return idFacture;
        }

        public void setIdFacture(Long idFacture) {
            this.idFacture = idFacture;
        }

        public Long getIdProduit() {
            return idProduit;
        }

        public void setIdProduit(Long idProduit) {
            this.idProduit = idProduit;
        }
    }
