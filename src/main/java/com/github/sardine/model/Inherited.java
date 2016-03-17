package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("inherited")
public class Inherited {

	private String href;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
}
