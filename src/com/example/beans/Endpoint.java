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
        "name_uri",
        "id_status"
})
public class Endpoint {

    @JsonProperty("id_uri")
    private String idUri;
    @JsonProperty("name_uri")
    private String nameUri;
    @JsonProperty("id_status")
    private String idStatus;

    @JsonProperty("id_uri")
    public String getIdUri() {
        return idUri;
    }

    @JsonProperty("id_uri")
    public void setIdUri(String idUri) {
        this.idUri = idUri;
    }

    @JsonProperty("name_uri")
    public String getNameUri() {
        return nameUri;
    }

    @JsonProperty("name_uri")
    public void setNameUri(String nameUri) {
        this.nameUri = nameUri;
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
        return new HashCodeBuilder().append(idUri).append(nameUri).append(idStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Endpoint) == false) {
            return false;
        }
        Endpoint rhs = ((Endpoint) other);
        return new EqualsBuilder().append(idUri, rhs.idUri).append(nameUri, rhs.nameUri).append(idStatus, rhs.idStatus).isEquals();
    }

}
