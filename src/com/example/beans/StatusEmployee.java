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
        "id_status",
        "name_status",
        "description_status"
})
public class StatusEmployee {

    @JsonProperty("id_status")
    private String idStatus;
    @JsonProperty("name_status")
    private String nameStatus;
    @JsonProperty("description_status")
    private String descriptionStatus;

    @JsonProperty("id_status")
    public String getIdStatus() {
        return idStatus;
    }

    @JsonProperty("id_status")
    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    @JsonProperty("name_status")
    public String getNameStatus() {
        return nameStatus;
    }

    @JsonProperty("name_status")
    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    @JsonProperty("description_status")
    public String getDescriptionStatus() {
        return descriptionStatus;
    }

    @JsonProperty("description_status")
    public void setDescriptionStatus(String descriptionStatus) {
        this.descriptionStatus = descriptionStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idStatus).append(nameStatus).append(descriptionStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StatusEmployee) == false) {
            return false;
        }
        StatusEmployee rhs = ((StatusEmployee) other);
        return new EqualsBuilder().append(idStatus, rhs.idStatus).append(nameStatus, rhs.nameStatus).append(descriptionStatus, rhs.descriptionStatus).isEquals();
    }

}

