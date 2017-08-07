package com.example.wrapper;

import com.example.beans.HeaderResponse;
import com.example.beans.InfoUser;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoUserWrapper extends HeaderResponse {
	@JsonProperty("businessResponse")
	private InfoUser businessResponse;
	
	@JsonProperty("businessResponse")
	public InfoUser getBusinessResponse() {
		return businessResponse;
	}
	
	@JsonProperty("businessResponse")
	public void setBusinessResponse(InfoUser businessResponse) {
		this.businessResponse = businessResponse;
	}
	
}
