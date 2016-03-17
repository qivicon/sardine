package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.*;


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
 *         &lt;element ref="{DAV:}report"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 */
@XStreamAlias("supported-report")
public class SupportedReport {

    protected Report report;

    /**
     * Gets the value of the report property.
     *
     * @return
     *     possible object is
     *     {@link Report }
     *
     */
    public Report getReport() {
        return report;
    }

    /**
     * Sets the value of the report property.
     *
     * @param value
     *     allowed object is
     *     {@link Report }
     *
     */
    public void setReport(Report value) {
        this.report = value;
    }

}
