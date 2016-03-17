package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.ConversionException;
import org.w3c.dom.Element;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;any processContents='skip' namespace='##other'/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 */
@XStreamAlias("report")
public class Report {

    protected Element any;

    /**
     * Gets the value of the any property.
     *
     * @return
     *     possible object is
     *     {@link Element }
     *
     */
    public Element getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
     *
     * @param value
     *     allowed object is
     *     {@link Element }
     *
     */
    public void setAny(Element value) {
        this.any = value;
    }

    /**
     * The readResolve method is called by XStream after the object is deserialized and can be used for validation
     *
     * @return deserialized object
     */
    private Object readResolve() {

        if (any == null) {
            throw new ConversionException("Field 'any' must not be null!");
        }

        return this;
    }
}
