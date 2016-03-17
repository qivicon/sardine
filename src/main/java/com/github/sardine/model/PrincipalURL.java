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
@XStreamAlias("principal-URL")
public class PrincipalURL {

	private String href;


	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}


}
