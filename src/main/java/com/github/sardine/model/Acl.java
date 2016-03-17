package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;


/**
 * <p>Java class for anonymous complex type.</p>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>
 *   &lt;D:owner&gt; 
 *        &lt;D:href&gt;http://www.example.com/acl/users/gstein&lt;/D:href&gt;
 *      &lt;/D:owner&gt;
 * </pre>
 * 
 */
@XStreamAlias("acl")
public class Acl {

	@XStreamImplicit
	private List<Ace> ace;

	public List<Ace> getAce() {
		return ace;
	}

	public void setAce(List<Ace> ace) {
		this.ace = ace;
	}
}
