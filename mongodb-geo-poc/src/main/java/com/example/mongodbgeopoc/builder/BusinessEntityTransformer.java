package com.example.mongodbgeopoc.builder;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.example.mongodbgeopoc.model.BusinessVO;
import com.example.mongodbgeopoc.model.LocationVO;
import com.example.mongodbgeopoc.model.LocationVOEntry;
import com.example.mongodbgeopoc.repository.domain.BusinessEntity;
import com.example.mongodbgeopoc.repository.domain.LocationData;
import com.example.mongodbgeopoc.repository.domain.LocationEntity;

public class BusinessEntityTransformer {

	public static BusinessEntity buildBusinessEntity(BusinessVO businessvo) {
		BusinessEntity businessEntity = new BusinessEntity();

		if (businessvo != null) {
			businessEntity.setBusinessId(businessvo.getId());
		}
		if (businessvo.getEventId() != null) {
			businessEntity.setEventId(businessvo.getEventId());
		}
		if (businessvo.getName() != null) {
			businessEntity.setName(businessvo.getName());
		}
		if (businessvo.getImage_url() != null) {
			businessEntity.setImage_url(businessvo.getImage_url());
		}
		if (businessvo.isIs_closed()) {
			businessEntity.setIs_closed(businessEntity.isIs_closed());
		}
		if (businessvo.getPhone() != null) {
			businessEntity.setPhone(businessvo.getPhone());
		}
		if (businessvo.getDisplay_phone() != null) {
			businessEntity.setDisplay_phone(businessvo.getDisplay_phone());
		}
		businessEntity.setRating(businessvo.getRating());
		businessEntity.setReview_count(businessvo.getReview_count());

		if (businessvo.getCoordinates() != null) {
			final GeoJsonPoint locationPoint = new GeoJsonPoint(
					Double.valueOf(businessvo.getCoordinates().getLongitude()),
					Double.valueOf(businessvo.getCoordinates().getLatitude()));

			businessEntity.setLocation(locationPoint);
		}
		if (businessvo.getLocation() != null) {
			LocationData location = LocationEntityTransformer.buildLocationEntity(businessvo.getLocation());
			businessEntity.setLocationData(location);
		}
		return businessEntity;
	}

	public static BusinessVO buildBusinessVO(BusinessEntity businessDBEntity) {
		BusinessVO businessVO = new BusinessVO();

		if (businessDBEntity != null) {
			businessVO.setId(businessDBEntity.getBusinessId());
		}
		if (businessDBEntity.getEventId() != null) {
			businessVO.setEventId(businessDBEntity.getEventId());
		}
		if (businessDBEntity.getName() != null) {
			businessVO.setName(businessDBEntity.getName());
		}
		if (businessDBEntity.getImage_url() != null) {
			businessVO.setImage_url(businessDBEntity.getImage_url());
		}
		if (businessDBEntity.isIs_closed()) {
			businessVO.setIs_closed(businessVO.isIs_closed());
		}
		if (businessDBEntity.getPhone() != null) {
			businessVO.setPhone(businessDBEntity.getPhone());
		}
		if (businessDBEntity.getDisplay_phone() != null) {
			businessVO.setDisplay_phone(businessDBEntity.getDisplay_phone());
		}
		businessVO.setRating(businessDBEntity.getRating());
		businessVO.setReview_count(businessDBEntity.getReview_count());

		if (businessDBEntity.getLocation() != null) {

			LocationVOEntry locationVOEntry = new LocationVOEntry();
			final GeoJsonPoint locationPoint = businessDBEntity.getLocation();
			locationVOEntry.setLatitude(String.valueOf(locationPoint.getX()));
			locationVOEntry.setLongitude(String.valueOf(locationPoint.getY()));
			businessVO.setCoordinates(locationVOEntry);
			
		}
		if (businessDBEntity.getLocationData() != null) {
			LocationVO location = LocationEntityTransformer.buildLocationVO(businessDBEntity.getLocationData());
			businessVO.setLocation(location);
		}
		return businessVO;
	}

}
