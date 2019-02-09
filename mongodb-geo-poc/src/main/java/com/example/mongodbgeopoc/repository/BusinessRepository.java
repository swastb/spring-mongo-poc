package com.example.mongodbgeopoc.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodbgeopoc.repository.domain.BusinessEntity;

public interface BusinessRepository extends MongoRepository<BusinessEntity, String> {
	List<BusinessEntity> findByLocationNear(Point p, Distance d);
}
