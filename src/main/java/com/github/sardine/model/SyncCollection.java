package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.ConversionException;

import java.math.BigInteger;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{DAV:}sync-token"/&gt;
 *         &lt;element ref="{DAV:}sync-level"/&gt;
 *         &lt;element ref="{DAV:}prop"/&gt;
 *         &lt;element ref="{DAV:}limit" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XStreamAlias("sync-collection")
public class SyncCollection {

    @XStreamAlias("sync-token")
    protected String syncToken;
    @XStreamAlias("sync-level")
    protected String syncLevel;
    protected Prop prop;
    protected BigInteger limit;

    /**
     * Gets the value of the syncToken property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSyncToken() {
        return syncToken;
    }

    /**
     * Sets the value of the syncToken property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSyncToken(String value) {
        this.syncToken = value;
    }

    /**
     * Gets the value of the syncLevel property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSyncLevel() {
        return syncLevel;
    }

    /**
     * Sets the value of the syncLevel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSyncLevel(String value) {
        this.syncLevel = value;
    }

    /**
     * Gets the value of the prop property.
     *
     * @return possible object is
     * {@link Prop }
     */
    public Prop getProp() {
        return prop;
    }

    /**
     * Sets the value of the prop property.
     *
     * @param value allowed object is
     *              {@link Prop }
     */
    public void setProp(Prop value) {
        this.prop = value;
    }

    /**
     * Gets the value of the limit property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setLimit(BigInteger value) {
        this.limit = value;
    }


    /**
     * The readResolve method is called by XStream after the object is deserialized and can be used for validation
     *
     * @return deserialized object
     */
    private Object readResolve() {

        if (syncLevel == null) {
            throw new ConversionException("Field 'syncLevel' must not be null!");
        }
        if (syncToken == null) {
            throw new ConversionException("Field 'syncToken' must not be null!");
        }
        if (prop == null) {
            throw new ConversionException("Field 'prop' must not be null!");
        }

        return this;
    }

}
