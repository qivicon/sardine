package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
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
 *         &lt;element ref="{DAV:}src" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{DAV:}dst" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XStreamAlias("link")
public class Link {

    private List<String> src;

    private List<String> dst;

    /**
     * Gets the value of the src property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the src property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSrc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSrc() {
        if (src == null) {
            src = new ArrayList<String>();
        }
        return this.src;
    }

    /**
     * Gets the value of the dst property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dst property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDst().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDst() {
        if (dst == null) {
            dst = new ArrayList<String>();
        }
        return this.dst;
    }

    /**
     * The readResolve method is called by XStream after the object is deserialized and can be used for validation
     *
     * @return deserialized object
     */
    private Object readResolve() {

        if (dst == null || dst.isEmpty()) {
            throw new ConversionException("Field 'dst' must not be null!");
        }

        if (src == null || src.isEmpty()) {
            throw new ConversionException("Field 'src' must not be null!");
        }

        return this;
    }

}
