package com.useradmin.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users {

    @Id
    @SequenceGenerator(name = "user_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long id;

    @Size(min = 0, max = 30)
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 0, max = 30)
    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Size(min = 0, max = 30)
    @NotNull
    @Column(name = "user_name")
    private String userName;

    @Size(min = 0, max = 50)
    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private boolean active;

    /*@JoinTable(name = "user_role", joinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id")},
        inverseJoinColumns = {
                @JoinColumn(name = "id_role", referencedColumnName = "id")})
@ManyToMany
private List<Role> roles = new ArrayList();*/

    public Users() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
