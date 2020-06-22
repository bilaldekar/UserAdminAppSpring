package com.useradmin.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity

public class OperationService extends Operation {


    @Id
    @SequenceGenerator(name = "operationser_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operationser_id_seq")
    private Long id;


    @Size(min = 0, max = 30)
    @Column
    private String format;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
