package com.useradmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.useradmin.models.Users;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role {

    @Id
    @SequenceGenerator(name = "role_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    private Long id;

    @Column(name = "description")
    private String description;
/*
    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<Users> users;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*
    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }*/
}
