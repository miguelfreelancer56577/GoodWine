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
        "token",
        "businessRequest"
})
public class HeaderRequest {

    @JsonProperty("id_user")
    private String idUser;
    @JsonProperty("token")
    private String token;
    @JsonProperty("businessRequest")
    private Object businessRequest;

    @JsonProperty("id_user")
    public String getIdUser() {
        return idUser;
    }

    @JsonProperty("id_user")
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("businessRequest")
    public Object getBusinessRequest() {
        return businessRequest;
    }

    @JsonProperty("businessRequest")
    public void setBusinessRequest(Object businessRequest) {
        this.businessRequest = businessRequest;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idUser).append(token).append(businessRequest).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HeaderRequest) == false) {
            return false;
        }
        HeaderRequest rhs = ((HeaderRequest) other);
        return new EqualsBuilder().append(idUser, rhs.idUser).append(token, rhs.token).append(businessRequest, rhs.businessRequest).isEquals();
    }

}