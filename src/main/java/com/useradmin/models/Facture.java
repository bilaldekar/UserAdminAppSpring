package com.useradmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Facture {


    @Id
    @SequenceGenerator(name = "facture_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facture_id_seq")
    private Long id;

    @Size(min = 0, max = 30)
    @Column
    private String code;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facture", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<FactureProduit> factureProduits;

    public Facture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
