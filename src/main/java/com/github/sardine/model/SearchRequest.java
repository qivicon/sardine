package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * <p>Java class for anonymous complex type.</p>
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>
    &lt;element name="searchrequest"&gt;
        &lt;complexType&gt;
            &lt;any processContents="skip" namespace="##other" minOccurs="1" maxOccurs="1" /&gt;
        &lt;/complexType&gt;
    &lt;/element&gt;
 * </pre>
 */
@XStreamAlias("searchrequest")
public class SearchRequest
{
	private String language;

	private String query;

	public SearchRequest()
	{
		this.language = "davbasic";
		this.query = "";
	}

	public SearchRequest(String language, String query)
	{
		this.language = language;
		this.query = query;
	}

	public final String getLanguage()
	{
		return language;
	}

	@XmlTransient
	public void setLanguage(String language)
	{
		this.language = language;
	}

	public final String getQuery()
	{
		return query;
	}

	@XmlTransient
	public void setQuery(String query)
	{
		this.query = query;
	}

	@XmlAnyElement
	public JAXBElement<String> getElement()
	{
		return new JAXBElement<String>(new QName("DAV:", language), String.class, query);
	}
}
