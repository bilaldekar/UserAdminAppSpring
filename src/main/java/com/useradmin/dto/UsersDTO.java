package com.useradmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
    @JsonProperty("userId")
    private Long id;
    @JsonProperty("userFirstName")
    private String first_name;
    @JsonProperty("userLastName")
    private String last_name;
    @JsonProperty("userUserName")
    private String user_name;
    @JsonProperty("userEmail")
    private String email;
    @JsonProperty("userActive")
    private boolean active;


}
