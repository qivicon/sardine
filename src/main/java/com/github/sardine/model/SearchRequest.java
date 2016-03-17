package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

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


	public void setLanguage(String language)
	{
		this.language = language;
	}


}
