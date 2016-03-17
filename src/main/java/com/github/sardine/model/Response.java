package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.converters.ConversionException;

import java.util.ArrayList;
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
 *         &lt;element ref="{DAV:}href" maxOccurs="unbounded"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element ref="{DAV:}status"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element ref="{DAV:}propstat" maxOccurs="unbounded"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{DAV:}error" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}responsedescription" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XStreamAlias("response")
public class Response {

    @XStreamImplicit(itemFieldName = "href")
    private List<String> href;

    @XStreamOmitField
    private String status;

    @XStreamImplicit
    private List<Propstat> propstat;
    private Error error;
    private String responsedescription;

    /**
	 * <p>
     * Gets the value of the href property.
     * </p>
	 * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the href property.
     * </p>
     * <p>
     * For example, to add a new item, do as follows:
	 * </p>
     * <pre>
     *    getHref().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list
	 * </p>
     * {@link String }
     */
    public List<String> getHref() {
        if(href == null) {
            href = new ArrayList<String>();
        }
        return this.href;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
	 * <p>
     * Gets the value of the propstat property.
     * </p>
	 * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propstat property.
     * </p>
     * <p>
     * For example, to add a new item, do as follows:
	 * </p>
     * <pre>
     *    getPropstat().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list
	 * </p>
     * {@link Propstat }
     */
    public List<Propstat> getPropstat() {
        if(propstat == null) {
            propstat = new ArrayList<Propstat>();
        }
        return this.propstat;
    }

    /**
     * Gets the value of the error property.
     *
     * @return possible object is
     *         {@link Error }
     */
    public Error getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     *
     * @param value allowed object is
     *              {@link Error }
     */
    public void setError(Error value) {
        this.error = value;
    }

    /**
     * Gets the value of the responsedescription property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getResponsedescription() {
        return responsedescription;
    }

    /**
     * Sets the value of the responsedescription property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setResponsedescription(String value) {
        this.responsedescription = value;
    }

    /**
     * The readResolve method is called by XStream after the object is deserialized and can be used for validation
     *
     * @return deserialized object
     */
    private Object readResolve() {

        if (href == null) {
            throw new ConversionException("Field 'href' must not be null!");
        }

        return this;
    }
}
