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
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element ref="{DAV:}activelock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XStreamAlias("lockdiscovery")
public class Lockdiscovery {

    @XStreamImplicit
    private List<Activelock> activelock;

    /**
     * Gets the value of the activelock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activelock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivelock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Activelock }
     * 
     * 
     */
    public List<Activelock> getActivelock() {
        if (activelock == null) {
            activelock = new ArrayList<Activelock>();
        }
        return this.activelock;
    }

}
