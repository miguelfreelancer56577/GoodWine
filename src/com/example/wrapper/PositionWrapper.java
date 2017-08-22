package com.example.wrapper;

import com.example.beans.HeaderResponse;
import com.example.beans.Position;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionWrapper extends HeaderResponse {
	@JsonProperty("businessResponse")
	private Position businessResponse;
	
	@JsonProperty("businessResponse")
	public Position getBusinessResponse() {
		return businessResponse;
	}
	
	@JsonProperty("businessResponse")
	public void setBusinessResponse(Position businessResponse) {
		this.businessResponse = businessResponse;
	}
}
