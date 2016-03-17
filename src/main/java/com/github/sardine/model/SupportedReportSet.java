package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.ConversionException;

import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element ref="{DAV:}supported-report" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XStreamAlias("supported-report-set")
public class SupportedReportSet {

    @XStreamAlias("supported-report")
    protected List<SupportedReport> supportedReport;

    /**
     * Gets the value of the supportedReport property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedReport property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedReport().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupportedReport }
     *
     *
     */
    public List<SupportedReport> getSupportedReport() {
        if (supportedReport == null) {
            supportedReport = new ArrayList<SupportedReport>();
        }
        return this.supportedReport;
    }

    /**
     * The readResolve method is called by XStream after the object is deserialized and can be used for validation
     *
     * @return deserialized object
     */
    private Object readResolve() {

        if (supportedReport == null) {
            throw new ConversionException("Field 'supportedReport' must not be null!");
        }

        return this;
    }

}
