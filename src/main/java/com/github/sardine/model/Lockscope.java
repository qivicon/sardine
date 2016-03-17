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
 *         &lt;element ref="{DAV:}exclusive"/&gt;
 *         &lt;element ref="{DAV:}shared"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XStreamAlias("lockscope")
public class Lockscope {

    private Exclusive exclusive;
    private Shared shared;

    /**
     * Gets the value of the exclusive property.
     * 
     * @return
     *     possible object is
     *     {@link Exclusive }
     *     
     */
    public Exclusive getExclusive() {
        return exclusive;
    }

    /**
     * Sets the value of the exclusive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Exclusive }
     *     
     */
    public void setExclusive(Exclusive value) {
        this.exclusive = value;
    }

    /**
     * Gets the value of the shared property.
     * 
     * @return
     *     possible object is
     *     {@link Shared }
     *     
     */
    public Shared getShared() {
        return shared;
    }

    /**
     * Sets the value of the shared property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shared }
     *     
     */
    public void setShared(Shared value) {
        this.shared = value;
    }

}
