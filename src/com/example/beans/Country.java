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
        "id_country",
        "name_country",
        "id_status"
})
public class Country {

    @JsonProperty("id_country")
    private String idCountry;
    @JsonProperty("name_country")
    private String nameCountry;
    @JsonProperty("id_status")
    private String idStatus;

    @JsonProperty("id_country")
    public String getIdCountry() {
        return idCountry;
    }

    @JsonProperty("id_country")
    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    @JsonProperty("name_country")
    public String getNameCountry() {
        return nameCountry;
    }

    @JsonProperty("name_country")
    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
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
        return new HashCodeBuilder().append(idCountry).append(nameCountry).append(idStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Country) == false) {
            return false;
        }
        Country rhs = ((Country) other);
        return new EqualsBuilder().append(idCountry, rhs.idCountry).append(nameCountry, rhs.nameCountry).append(idStatus, rhs.idStatus).isEquals();
    }

}

