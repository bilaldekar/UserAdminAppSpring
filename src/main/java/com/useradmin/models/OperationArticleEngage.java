package com.useradmin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class OperationArticleEngage  extends Operation {


    @Id
    private Long id;


    @Size(min = 0, max = 30)
    @Column
    private String port_livraison;


    @Size(min = 0, max = 30)
    @Column
    private String engage;

    public String getEngage() {
        return engage;
    }

    public void setEngage(String engage) {
        this.engage = engage;
    }
}
