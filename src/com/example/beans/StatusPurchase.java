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
        "description_status"
})
public class StatusPurchase {

    @JsonProperty("id_status")
    private String idStatus;
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
        return new HashCodeBuilder().append(idStatus).append(descriptionStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StatusPurchase) == false) {
            return false;
        }
        StatusPurchase rhs = ((StatusPurchase) other);
        return new EqualsBuilder().append(idStatus, rhs.idStatus).append(descriptionStatus, rhs.descriptionStatus).isEquals();
    }

}