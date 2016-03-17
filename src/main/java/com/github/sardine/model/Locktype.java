package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.ConversionException;


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
 *         &lt;element ref="{DAV:}write"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 */
@XStreamAlias( "locktype")
public class Locktype {

    private Write write;

    /**
     * Gets the value of the write property.
     * 
     * @return
     *     possible object is
     *     {@link Write }
     *     
     */
    public Write getWrite() {
        return write;
    }

    /**
     * Sets the value of the write property.
     * 
     * @param value
     *     allowed object is
     *     {@link Write }
     *     
     */
    public void setWrite(Write value) {
        this.write = value;
    }

    /**
     * The readResolve method is called by XStream after the object is deserialized and can be used for validation
     *
     * @return deserialized object
     */
    private Object readResolve() {

        if (write == null) {
            throw new ConversionException("Field 'write' must not be null!");
        }

        return this;
    }

}
