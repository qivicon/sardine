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
 *         &lt;element ref="{DAV:}allprop"/&gt;
 *         &lt;element ref="{DAV:}propname"/&gt;
 *         &lt;element ref="{DAV:}prop"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XStreamAlias("propfind")
public class Propfind {

    private Allprop allprop;
    private Propname propname;
    private Prop prop;

    /**
     * Gets the value of the allprop property.
     * 
     * @return
     *     possible object is
     *     {@link Allprop }
     *     
     */
    public Allprop getAllprop() {
        return allprop;
    }

    /**
     * Sets the value of the allprop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Allprop }
     *     
     */
    public void setAllprop(Allprop value) {
        this.allprop = value;
    }

    /**
     * Gets the value of the propname property.
     * 
     * @return
     *     possible object is
     *     {@link Propname }
     *     
     */
    public Propname getPropname() {
        return propname;
    }

    /**
     * Sets the value of the propname property.
     * 
     * @param value
     *     allowed object is
     *     {@link Propname }
     *     
     */
    public void setPropname(Propname value) {
        this.propname = value;
    }

    /**
     * Gets the value of the prop property.
     *
     * @return
     *     possible object is
     *     {@link Prop }
     *
     */
    public Prop getProp() {
        return prop;
    }

    /**
     * Sets the value of the prop property.
     *
     * @param value
     *     allowed object is
     *     {@link Prop }
     *
     */
    public void setProp(Prop value) {
        this.prop = value;
    }

}
