package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

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
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element ref="{DAV:}remove"/&gt;
 *         &lt;element ref="{DAV:}set"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 */
@XStreamAlias("propertyupdate")
public class Propertyupdate {

    @XStreamImplicit
    private List<PropertyAction> removeOrSet;

    /**
     * Gets the value of the removeOrSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the removeOrSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemoveOrSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Remove }
     * {@link Set }
     * 
     * 
     */
    public List<PropertyAction> getRemoveOrSet() {
        if (removeOrSet == null) {
            removeOrSet = new ArrayList<PropertyAction>();
        }
        return this.removeOrSet;
    }

}
