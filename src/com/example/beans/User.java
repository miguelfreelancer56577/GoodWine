package com.example.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Maricruz on 28/07/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id_user",
        "id_employee",
        "name_user",
        "password",
        "token",
        "day_entry"
})
public class User {

    @JsonProperty("id_user")
    private String idUser;
    @JsonProperty("id_employee")
    private String idEmployee;
    @JsonProperty("name_user")
    private String nameUser;
    @JsonProperty("password")
    private String password;
    @JsonProperty("token")
    private String token;
    @JsonProperty("day_entry")
    private String dayEntry;

    @JsonProperty("id_user")
    public String getIdUser() {
        return idUser;
    }

    @JsonProperty("id_user")
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @JsonProperty("id_employee")
    public String getIdEmployee() {
        return idEmployee;
    }

    @JsonProperty("id_employee")
    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @JsonProperty("name_user")
    public String getNameUser() {
        return nameUser;
    }

    @JsonProperty("name_user")
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("day_entry")
    public String getDayEntry() {
        return dayEntry;
    }

    @JsonProperty("day_entry")
    public void setDayEntry(String dayEntry) {
        this.dayEntry = dayEntry;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idUser).append(idEmployee).append(nameUser).append(password).append(token).append(dayEntry).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(idUser, rhs.idUser).append(idEmployee, rhs.idEmployee).append(nameUser, rhs.nameUser).append(password, rhs.password).append(token, rhs.token).append(dayEntry, rhs.dayEntry).isEquals();
    }

}