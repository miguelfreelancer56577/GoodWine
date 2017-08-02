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
        "id_employee",
        "first_name",
        "surname",
        "last_name",
        "age",
        "email",
        "id_position",
        "id_status"
})
public class Employee {

    @JsonProperty("id_employee")
    private String idEmployee;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("age")
    private String age;
    @JsonProperty("email")
    private String email;
    @JsonProperty("id_position")
    private String idPosition;
    @JsonProperty("id_status")
    private String idStatus;

    @JsonProperty("id_employee")
    public String getIdEmployee() {
        return idEmployee;
    }

    @JsonProperty("id_employee")
    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    @JsonProperty("surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("id_position")
    public String getIdPosition() {
        return idPosition;
    }

    @JsonProperty("id_position")
    public void setIdPosition(String idPosition) {
        this.idPosition = idPosition;
    }

    @JsonProperty("id_status")
    public String getIdStatus() {
        return idStatus;
    }

    @JsonProperty("id_status")
    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idEmployee).append(firstName).append(surname).append(lastName).append(age).append(email).append(idPosition).append(idStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Employee) == false) {
            return false;
        }
        Employee rhs = ((Employee) other);
        return new EqualsBuilder().append(idEmployee, rhs.idEmployee).append(firstName, rhs.firstName).append(surname, rhs.surname).append(lastName, rhs.lastName).append(age, rhs.age).append(email, rhs.email).append(idPosition, rhs.idPosition).append(idStatus, rhs.idStatus).isEquals();
    }

}
