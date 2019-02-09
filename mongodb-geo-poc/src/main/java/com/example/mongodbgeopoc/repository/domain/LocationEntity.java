package com.example.mongodbgeopoc.repository.domain;

import java.util.Objects;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
public class LocationEntity {
	private String id;
	private GeoJsonPoint location;

	public LocationEntity(final GeoJsonPoint location) {
		this.location = location;
	}

	public String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public GeoJsonPoint getLocation() {
		return this.location;
	}

	public void setLocation(final GeoJsonPoint location) {
		this.location = location;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		final LocationEntity that = (LocationEntity) o;
		return Objects.equals(this.getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}

}
