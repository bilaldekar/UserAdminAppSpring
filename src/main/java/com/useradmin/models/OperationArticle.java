package com.useradmin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class OperationArticle extends Operation {

    @Id
    private Long id;


    @Size(min = 0, max = 30)
    @Column
    private String port_livraison;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPort_livraison() {
        return port_livraison;
    }

    public void setPort_livraison(String port_livraison) {
        this.port_livraison = port_livraison;
    }
}
