package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;


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
@XStreamAlias("principal-collection-set")
public class PrincipalCollectionSet {

	private List<String> href;

	public List<String> getHref() {
		return href;
	}

	public void setHref(List<String> href) {
		this.href = href;
	}


}
