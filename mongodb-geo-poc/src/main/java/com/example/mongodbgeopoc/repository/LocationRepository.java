package com.example.mongodbgeopoc.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodbgeopoc.repository.domain.LocationEntity;

public interface LocationRepository extends
		MongoRepository<LocationEntity, String>/* , CustomLocationRepository */ {
/*	List<LocationEntity> findBySubjectAndLocationNear(String sid, Point p, Distance d);
*/	
	List<LocationEntity> findByLocationNear(Point p, Distance d);
}
