package com.useradmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;


    @Entity
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public class Produit {


        @Id
        @SequenceGenerator(name = "produit_id_seq", initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produit_id_seq")
        private Long id;

        @Size(min = 0, max = 30)
        @Column
        private String code;

        public Produit() {
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
