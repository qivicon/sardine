package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.ConversionException;


/**
 * <p>Java class for anonymous complex type.</p>
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <p>
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{DAV:}lockscope"/&gt;
 *         &lt;element ref="{DAV:}locktype"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XStreamAlias("lockentry")
public class Lockentry {

    private Lockscope lockscope;

    private Locktype locktype;

    /**
     * Gets the value of the lockscope property.
     *
     * @return possible object is
     * {@link Lockscope }
     */
    public Lockscope getLockscope() {
        return lockscope;
    }

    /**
     * Sets the value of the lockscope property.
     *
     * @param value allowed object is
     *              {@link Lockscope }
     */
    public void setLockscope(Lockscope value) {
        this.lockscope = value;
    }

    /**
     * Gets the value of the locktype property.
     *
     * @return possible object is
     * {@link Locktype }
     */
    public Locktype getLocktype() {
        return locktype;
    }

    /**
     * Sets the value of the locktype property.
     *
     * @param value allowed object is
     *              {@link Locktype }
     */
    public void setLocktype(Locktype value) {
        this.locktype = value;
    }

    /**
     * The readResolve method is called by XStream after the object is deserialized and can be used for validation
     *
     * @return deserialized object
     */
    private Object readResolve() {

        if (lockscope == null) {
            throw new ConversionException("Field 'lockscope' must not be null!");
        }

        if (locktype == null) {
            throw new ConversionException("Field 'locktype' must not be null!");
        }

        return this;
    }
}
