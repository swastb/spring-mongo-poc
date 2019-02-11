package com.example.mongodbgeopoc.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mongodbgeopoc.builder.BusinessEntityTransformer;
import com.example.mongodbgeopoc.model.BusinessVO;
import com.example.mongodbgeopoc.model.TruckResponse;
import com.example.mongodbgeopoc.model.Trucks;
import com.example.mongodbgeopoc.model.common.LinkCommentConstants;
import com.example.mongodbgeopoc.model.common.SuperLink;
import com.example.mongodbgeopoc.repository.BusinessRepository;
import com.example.mongodbgeopoc.repository.domain.BusinessEntity;

@RestController
@RequestMapping("api/v1.0/foodtruck")
public class BusinessResourceController {

	@Autowired
	private BusinessRepository businessRepository;

	@RequestMapping(method = RequestMethod.GET)
	public final ResponseEntity<TruckResponse> getLocations(@RequestParam("lat") String latitude,
			@RequestParam("long") String longitude, @RequestParam("distance") double distance) {

		// if (subjects == null || subjects.length() < 1) {

		Trucks trucks = new Trucks();
		List<BusinessVO> businessVOList = new ArrayList<BusinessVO>();
		GeoResults<BusinessEntity> businessEntityList = this.businessRepository.findByLocationNear(
				new Point(Double.valueOf(longitude), Double.valueOf(latitude)),
				new Distance(distance, Metrics.KILOMETERS));

		for (GeoResult<BusinessEntity> business : businessEntityList) {
			BusinessVO bVO = BusinessEntityTransformer.buildBusinessVO(business.getContent());
			bVO.setDistance(business.getDistance().getValue());
			final String menuUriString = bVO.getGid() + "/menus/";

			SuperLink link = new SuperLink(new Link(menuUriString, "food items"), LinkCommentConstants.MENU_COMMENT,
					"GET");
			bVO.add(link);
			businessVOList.add(bVO);

		}
		trucks.setBusinesses(businessVOList);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		trucks.add(new Link(uriString, "base"));
		return ResponseEntity.ok(new TruckResponse(trucks, 200));

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public final void addTruckInformation(@RequestBody BusinessVO entries) {

		BusinessEntity business = BusinessEntityTransformer.buildBusinessEntity(entries);
		this.businessRepository.save(business);
	}

}
