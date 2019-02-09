package com.example.mongodbgeopoc.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbgeopoc.builder.BusinessEntityTransformer;
import com.example.mongodbgeopoc.model.BusinessVO;
import com.example.mongodbgeopoc.repository.BusinessRepository;
import com.example.mongodbgeopoc.repository.LocationRepository;
import com.example.mongodbgeopoc.repository.domain.BusinessEntity;

@RestController
@RequestMapping("business")
public class BusinessResourceController {
	@Autowired
	private LocationRepository repository;

	@Autowired
	private BusinessRepository businessRepository;

	@RequestMapping(method = RequestMethod.GET)
	public final List<BusinessVO> getLocations(@RequestParam("lat") String latitude,
			@RequestParam("long") String longitude, @RequestParam("d") double distance,
			@RequestParam(value = "s", required = false) String subjects) {

		// if (subjects == null || subjects.length() < 1) {

		List<BusinessVO> businessVOList = new ArrayList<BusinessVO>();
		List<BusinessEntity> businessEntityList = this.businessRepository.findByLocationNear(
				new Point(Double.valueOf(longitude), Double.valueOf(latitude)),
				new Distance(distance, Metrics.KILOMETERS));

		for (BusinessEntity business : businessEntityList) {
			BusinessVO bVO = BusinessEntityTransformer.buildBusinessVO(business);
			businessVOList.add(bVO);
		}
		return businessVOList;

		// }
		/*
		 * else { return this.repository.findBySubjectAndLocationNear(subjects,
		 * new Point(Double.valueOf(latitude), Double.valueOf(longitude)), new
		 * Distance(distance, Metrics.KILOMETERS)); }
		 */

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public final void addTruckInformation(@RequestBody BusinessVO entries) {

		BusinessEntity business = BusinessEntityTransformer.buildBusinessEntity(entries);
		this.businessRepository.save(business);
	}

}
