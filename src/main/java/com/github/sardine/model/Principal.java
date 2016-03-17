package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * <p>Java class for anonymous complex type.</p>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;any/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XStreamAlias("principal")
public class Principal {

	private String href;
	private Property property;
	private All all;
	private Authenticated authenticated;
	private Unauthenticated unauthenticated;
	private Self self;
 

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public All getAll() {
		return all;
	}

	public void setAll(All all) {
		this.all = all;
	}

	public Authenticated getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Authenticated authenticated) {
		this.authenticated = authenticated;
	}

	public Unauthenticated getUnauthenticated() {
		return unauthenticated;
	}

	public void setUnauthenticated(Unauthenticated unauthenticated) {
		this.unauthenticated = unauthenticated;
	}

	public Self getSelf() {
		return self;
	}

	public void setSelf(Self self) {
		this.self = self;
	}


}
