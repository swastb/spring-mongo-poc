package com.example.mongodbgeopoc.repository;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodbgeopoc.repository.domain.BusinessEntity;

public interface BusinessRepository extends MongoRepository<BusinessEntity, String> {
	//List<BusinessEntity> findByLocationNear(Point p, Distance d);
	
	GeoResults<BusinessEntity> findByLocationNear(Point p, Distance d);
}
