package com.example.mongodbgeopoc.builder;

import com.example.mongodbgeopoc.model.LocationVO;
import com.example.mongodbgeopoc.repository.domain.LocationData;

public class LocationEntityTransformer {

	public static LocationData buildLocationEntity(LocationVO locationVO) {
		LocationData locationEntity = new LocationData();
		if (locationVO.getAddress1() != null) {
			locationEntity.setAddress1(locationVO.getAddress1());
		}
		if (locationVO.getAddress2() != null) {
			locationEntity.setAddress2(locationVO.getAddress2());
		}
		if (locationVO.getAddress3() != null) {
			locationEntity.setAddress3(locationVO.getAddress3());
		}
		if (locationVO.getCity() != null) {
			locationEntity.setCity(locationVO.getCity());
		}
		if (locationVO.getZip_code() != null) {
			locationEntity.setZip_code(locationVO.getZip_code());
		}
		if (locationVO.getCountry() != null) {
			locationEntity.setCountry(locationVO.getCountry());
		}
		if (locationVO.getState() != null) {
			locationEntity.setState(locationVO.getState());
		}
		if (locationVO.getDisplay_address() != null) {
			locationEntity.setDisplay_address(locationVO.getDisplay_address());
		}

		return locationEntity;
	}

	public static LocationVO buildLocationVO(LocationData locationDBEntity) {
		LocationVO locationVO = new LocationVO();
		if (locationDBEntity.getAddress1() != null) {
			locationVO.setAddress1(locationDBEntity.getAddress1());
		}
		if (locationDBEntity.getAddress2() != null) {
			locationVO.setAddress2(locationDBEntity.getAddress2());
		}
		if (locationDBEntity.getAddress3() != null) {
			locationVO.setAddress3(locationDBEntity.getAddress3());
		}
		if (locationDBEntity.getCity() != null) {
			locationVO.setCity(locationDBEntity.getCity());
		}
		if (locationDBEntity.getZip_code() != null) {
			locationVO.setZip_code(locationDBEntity.getZip_code());
		}
		if (locationDBEntity.getCountry() != null) {
			locationVO.setCountry(locationDBEntity.getCountry());
		}
		if (locationDBEntity.getState() != null) {
			locationVO.setState(locationDBEntity.getState());
		}
		if (locationDBEntity.getDisplay_address() != null) {
			locationVO.setDisplay_address(locationDBEntity.getDisplay_address());
		}

		return locationVO;
	}

}
