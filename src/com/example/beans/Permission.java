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
        "id_uri",
        "id_employee"
})
public class Permission {

    @JsonProperty("id_uri")
    private String idUri;
    @JsonProperty("id_employee")
    private String idEmployee;

    @JsonProperty("id_uri")
    public String getIdUri() {
        return idUri;
    }

    @JsonProperty("id_uri")
    public void setIdUri(String idUri) {
        this.idUri = idUri;
    }

    @JsonProperty("id_employee")
    public String getIdEmployee() {
        return idEmployee;
    }

    @JsonProperty("id_employee")
    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idUri).append(idEmployee).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Permission) == false) {
            return false;
        }
        Permission rhs = ((Permission) other);
        return new EqualsBuilder().append(idUri, rhs.idUri).append(idEmployee, rhs.idEmployee).isEquals();
    }

}