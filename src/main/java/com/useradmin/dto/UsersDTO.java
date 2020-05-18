package com.useradmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.useradmin.models.Role;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
    @JsonProperty("userId")
    private Long id;
    @JsonProperty("userFirstName")
    private String firstName;
    @JsonProperty("userLastName")
    private String lastName;
    @JsonProperty("userUserName")
    private String userName;
    @JsonProperty("userEmail")
    private String email;
    @JsonProperty("userActive")
    private boolean active;

    @JsonProperty("userRoles")
    private List<RolesDTO> roles = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<RolesDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesDTO> roles) {
        this.roles = roles;
    }
}
