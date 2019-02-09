package com.example.mongodbgeopoc.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbgeopoc.builder.BusinessEntityTransformer;
import com.example.mongodbgeopoc.model.BusinessVO;
import com.example.mongodbgeopoc.model.LocationVOEntry;
import com.example.mongodbgeopoc.repository.BusinessRepository;
import com.example.mongodbgeopoc.repository.LocationRepository;
import com.example.mongodbgeopoc.repository.domain.BusinessEntity;
import com.example.mongodbgeopoc.repository.domain.LocationEntity;

@RestController
@RequestMapping("location")
public class LocationResourceController {
	@Autowired
	private LocationRepository repository;

	@Autowired
	private BusinessRepository businessRepository;

	@RequestMapping(method = RequestMethod.GET)
	public final List<LocationEntity> getLocations(@RequestParam("lat") String latitude,
			@RequestParam("long") String longitude, @RequestParam("d") double distance,
			@RequestParam(value = "s", required = false) String subjects) {

		// if (subjects == null || subjects.length() < 1) {
		return this.repository.findByLocationNear(new Point(Double.valueOf(latitude), Double.valueOf(longitude)),
				new Distance(distance, Metrics.KILOMETERS));

		// }
		/*
		 * else { return this.repository.findBySubjectAndLocationNear(subjects,
		 * new Point(Double.valueOf(latitude), Double.valueOf(longitude)), new
		 * Distance(distance, Metrics.KILOMETERS)); }
		 */

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public final void addLocations(@RequestParam("s") String sid, @RequestBody List<LocationVOEntry> entries) {

		List<LocationEntity> entities = new ArrayList<>();
		for (LocationVOEntry location : entries) {
			final GeoJsonPoint locationPoint = new GeoJsonPoint(Double.valueOf(location.getLatitude()),
					Double.valueOf(location.getLongitude()));

			LocationEntity entry = new LocationEntity(locationPoint);
			entities.add(entry);
		}
		this.repository.saveAll(entities);
	}
}
