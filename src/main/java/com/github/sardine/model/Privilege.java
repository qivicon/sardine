package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;


@XStreamAlias("privilege")
public class Privilege {

    @XStreamImplicit
	private List<SimplePrivilege> content;

	public List<SimplePrivilege> getContent() {
		if (content==null)
			content = new ArrayList<SimplePrivilege>();
		return content;
	}

	public void setContent(List<SimplePrivilege> content) {
		this.content = content;
	}

}
