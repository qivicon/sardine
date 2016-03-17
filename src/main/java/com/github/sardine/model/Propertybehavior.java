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
 *       &lt;choice&gt;
 *         &lt;element ref="{DAV:}omit"/&gt;
 *         &lt;element ref="{DAV:}keepalive"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XStreamAlias("propertybehavior")
public class Propertybehavior {

    private Omit omit;
    private Keepalive keepalive;

    /**
     * Gets the value of the omit property.
     * 
     * @return
     *     possible object is
     *     {@link Omit }
     *     
     */
    public Omit getOmit() {
        return omit;
    }

    /**
     * Sets the value of the omit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Omit }
     *     
     */
    public void setOmit(Omit value) {
        this.omit = value;
    }

    /**
     * Gets the value of the keepalive property.
     * 
     * @return
     *     possible object is
     *     {@link Keepalive }
     *     
     */
    public Keepalive getKeepalive() {
        return keepalive;
    }

    /**
     * Sets the value of the keepalive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Keepalive }
     *     
     */
    public void setKeepalive(Keepalive value) {
        this.keepalive = value;
    }

}
