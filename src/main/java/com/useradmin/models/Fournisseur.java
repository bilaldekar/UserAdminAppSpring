package com.useradmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "fournisseur")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fournisseur {

    @Id
    @SequenceGenerator(name = "fournisseur_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fournisseur_id_seq")
    private Long id;

    @Size(min = 0, max = 30)
    @NotNull
    @Column(name = "name")
    private String name;

    @Size(min = 0, max = 30)
    @NotNull
    @Column(name = "reference")
    private String reference;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
