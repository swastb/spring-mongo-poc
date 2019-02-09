package com.example.mongodbgeopoc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Trucks implements Serializable {

	private static final long serialVersionUID = -208450163190261308L;

	private List<BusinessVO> businesses = new ArrayList<BusinessVO>();

	public List<BusinessVO> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(List<BusinessVO> businesses) {
		this.businesses = businesses;
	}

}
