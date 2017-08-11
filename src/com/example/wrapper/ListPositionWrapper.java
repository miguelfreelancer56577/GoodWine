package com.example.wrapper;

import java.util.ArrayList;

import com.example.beans.HeaderResponse;
import com.example.beans.Position;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListPositionWrapper extends HeaderResponse {
	@JsonProperty("businessResponse")
	private ArrayList<Position> businessResponse;
	
	@JsonProperty("businessResponse")
	public ArrayList<Position> getBusinessResponse() {
		return businessResponse;
	}
	
	@JsonProperty("businessResponse")
	public void setBusinessResponse(ArrayList<Position> businessResponse) {
		this.businessResponse = businessResponse;
	}
}
