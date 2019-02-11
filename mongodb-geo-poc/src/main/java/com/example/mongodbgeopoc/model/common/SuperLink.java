package com.example.mongodbgeopoc.model.common;

import org.springframework.hateoas.Link;

public class SuperLink extends Link {

	private static final long serialVersionUID = -3092835032945977165L;
	private String _comments;

	public SuperLink(Link link, String _comments, String type) {
		super(link.getHref(), link.getRel());
		super.withType(type);
		this._comments = _comments;
	}

	public String get_comments() {
		return _comments;
	}

	public void set_comments(String _comments) {
		this._comments = _comments;
	}

}
