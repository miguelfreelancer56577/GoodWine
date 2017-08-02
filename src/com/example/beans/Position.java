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
        "id_position",
        "name_position",
        "description_position",
        "id_status"
})
public class Position {

    @JsonProperty("id_position")
    private String idPosition;
    @JsonProperty("name_position")
    private String namePosition;
    @JsonProperty("description_position")
    private String descriptionPosition;
    @JsonProperty("id_status")
    private String idStatus;

    @JsonProperty("id_position")
    public String getIdPosition() {
        return idPosition;
    }

    @JsonProperty("id_position")
    public void setIdPosition(String idPosition) {
        this.idPosition = idPosition;
    }

    @JsonProperty("name_position")
    public String getNamePosition() {
        return namePosition;
    }

    @JsonProperty("name_position")
    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    @JsonProperty("description_position")
    public String getDescriptionPosition() {
        return descriptionPosition;
    }

    @JsonProperty("description_position")
    public void setDescriptionPosition(String descriptionPosition) {
        this.descriptionPosition = descriptionPosition;
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
        return new HashCodeBuilder().append(idPosition).append(namePosition).append(descriptionPosition).append(idStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Position) == false) {
            return false;
        }
        Position rhs = ((Position) other);
        return new EqualsBuilder().append(idPosition, rhs.idPosition).append(namePosition, rhs.namePosition).append(descriptionPosition, rhs.descriptionPosition).append(idStatus, rhs.idStatus).isEquals();
    }

}

