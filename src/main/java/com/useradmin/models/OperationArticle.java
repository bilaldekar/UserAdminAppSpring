package com.useradmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

//@Inheritance(strategy = InheritanceType.JOINED)
public class OperationArticle extends Operation {

    @Id
    @SequenceGenerator(name = "operationart_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operationart_id_seq")
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
