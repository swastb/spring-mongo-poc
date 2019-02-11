package com.example.mongodbgeopoc.model;

import com.example.mongodbgeopoc.model.common.RestResponse;

public class TruckResponse extends RestResponse {

	private Trucks trucks;

	public TruckResponse(Trucks trucks, int statusCode) {
		this.trucks = trucks;
		super.statusCode = statusCode;
	}

	public Trucks getTrucks() {
		return trucks;
	}

	public void setTrucks(Trucks trucks) {
		this.trucks = trucks;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
