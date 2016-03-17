package com.github.sardine.model;

import com.github.sardine.model.converter.QNameConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import javax.xml.namespace.QName;


/**
 * <p>Java class for anonymous complex type.</p>
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element ref="{DAV:}creationdate" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}displayname" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getcontentlanguage" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getcontentlength" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getcontenttype" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getetag" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getlastmodified" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}lockdiscovery" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}resourcetype" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}supportedlock" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}owner" minOccurs="0"/&gt;  &lt;!-- (for DAV:acl) --&gt;
 *         &lt;any/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XStreamAlias( "property")
@XStreamConverter(QNameConverter.class)
public class Property {

	private QName property;

	public QName getProperty() {
		return property;
	}

	public void setProperty(QName property) {
		this.property = property;
	}

}
