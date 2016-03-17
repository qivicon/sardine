package com.github.sardine.model;

import com.github.sardine.model.converter.CustomPropReflectionConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.</p>
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <p>
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element ref="{DAV:}creationdate" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}displayname" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getcontentlanguage" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getcontentlength" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getcontenttype" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getetag" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}getlastmodified" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}lockdiscovery" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}resourcetype" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}supportedlock" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}quota-available-bytes" minOccurs="0"/&gt;
 *         &lt;element ref="{DAV:}quota-used-bytes" minOccurs="0"/&gt;
 *         &lt;any processContents='skip' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */

@XStreamAlias("prop")
@XStreamConverter(CustomPropReflectionConverter.class)
public class Prop {

    @XStreamImplicit(itemFieldName = "creationdate")
    private List<String> creationdate;

    @XStreamImplicit(itemFieldName = "displayname")
    private List<String> displayname;

    @XStreamImplicit(itemFieldName = "getcontentlanguage")
    private List<String> getcontentlanguage;

    @XStreamImplicit(itemFieldName = "getcontentlength")
    private List<String> getcontentlength;

    @XStreamImplicit(itemFieldName = "getcontenttype")
    private List<String> getcontenttype;

    @XStreamImplicit(itemFieldName = "getetag")
    private List<String> getetag;

    @XStreamImplicit(itemFieldName = "getlastmodified")
    private List<String> getlastmodified;

    private Lockdiscovery lockdiscovery;

    private Resourcetype resourcetype;

    private Supportedlock supportedlock;
    @XStreamAlias("supported-report-set")
    private SupportedReportSet supportedReportSet;
    @XStreamAlias("quota-available-bytes")
    private QuotaAvailableBytes quotaAvailableBytes;
    @XStreamAlias("quota-used-bytes")
    private QuotaUsedBytes quotaUsedBytes;

    @XStreamOmitField
    private List<Element> any;

    //ACL elements
    private Owner owner;
    private Group group;
    private Acl acl;
    @XStreamAlias("principal-collection-set")
    private PrincipalCollectionSet principalCollectionSet;
    @XStreamAlias("principal-URL")
    private PrincipalURL principalURL;


    /**
     * Gets the value of the creationdate property.
     *
     * @return possible object is
     * {@link Creationdate }
     */
    public List<String> getCreationdate() {
        return creationdate;
    }

    /**
     * Sets the value of the creationdate property.
     *
     * @param value allowed object is
     *              {@link Creationdate }
     */
    public void setCreationdate(List<String> value) {
        this.creationdate = value;
    }

    /**
     * Gets the value of the displayname property.
     *
     * @return possible object is
     * {@link Displayname }
     */
    public List<String> getDisplayname() {
        return displayname;
    }

    /**
     * Sets the value of the displayname property.
     *
     * @param value allowed object is
     *              {@link Displayname }
     */
    public void setDisplayname(List<String> value) {
        this.displayname = value;
    }

    /**
     * Gets the value of the getcontentlanguage property.
     *
     * @return possible object is
     * {@link Getcontentlanguage }
     */
    public List<String> getGetcontentlanguage() {
        return getcontentlanguage;
    }

    /**
     * Sets the value of the getcontentlanguage property.
     *
     * @param value allowed object is
     *              {@link Getcontentlanguage }
     */
    public void setGetcontentlanguage(List<String> value) {
        this.getcontentlanguage = value;
    }

    /**
     * Gets the value of the getcontentlength property.
     *
     * @return possible object is
     * {@link Getcontentlength }
     */
    public List<String> getGetcontentlength() {
        return getcontentlength;
    }

    /**
     * Sets the value of the getcontentlength property.
     *
     * @param value allowed object is
     *              {@link Getcontentlength }
     */
    public void setGetcontentlength(List<String> value) {
        this.getcontentlength = value;
    }

    /**
     * Gets the value of the getcontenttype property.
     *
     * @return possible object is
     * {@link Getcontenttype }
     */
    public List<String> getGetcontenttype() {
        return getcontenttype;
    }

    /**
     * Sets the value of the getcontenttype property.
     *
     * @param value allowed object is
     *              {@link Getcontenttype }
     */
    public void setGetcontenttype(List<String> value) {
        this.getcontenttype = value;
    }

    /**
     * Gets the value of the getetag property.
     *
     * @return possible object is
     * {@link Getetag }
     */
    public List<String> getGetetag() {
        return getetag;
    }

    /**
     * Sets the value of the getetag property.
     */
    public void setGetetag(List<String> value) {
        this.getetag = value;
    }

    /**
     * Gets the value of the getlastmodified property.
     */
    public List<String> getGetlastmodified() {
        return getlastmodified;
    }

    /**
     * Sets the value of the getlastmodified property.
     *
     * @param value allowed object is
     *              {@link Getlastmodified }
     */
    public void setGetlastmodified(List<String> value) {
        this.getlastmodified = value;
    }

    /**
     * Gets the value of the lockdiscovery property.
     *
     * @return possible object is
     * {@link Lockdiscovery }
     */
    public Lockdiscovery getLockdiscovery() {
        return lockdiscovery;
    }

    /**
     * Sets the value of the lockdiscovery property.
     *
     * @param value allowed object is
     *              {@link Lockdiscovery }
     */
    public void setLockdiscovery(Lockdiscovery value) {
        this.lockdiscovery = value;
    }

    /**
     * Gets the value of the resourcetype property.
     *
     * @return possible object is
     * {@link Resourcetype }
     */
    public Resourcetype getResourcetype() {
        return resourcetype;
    }

    /**
     * Sets the value of the resourcetype property.
     *
     * @param value allowed object is
     *              {@link Resourcetype }
     */
    public void setResourcetype(Resourcetype value) {
        this.resourcetype = value;
    }

    /**
     * Gets the value of the supportedlock property.
     *
     * @return possible object is
     * {@link Supportedlock }
     */
    public Supportedlock getSupportedlock() {
        return supportedlock;
    }

    /**
     * Sets the value of the supportedlock property.
     *
     * @param value allowed object is
     *              {@link Supportedlock }
     */
    public void setSupportedlock(Supportedlock value) {
        this.supportedlock = value;
    }

    /**
     * Gets the value of the supportedReportSet property.
     *
     * @return possible object is
     * {@link SupportedReportSet }
     */
    public SupportedReportSet getSupportedReportSet() {
        return supportedReportSet;
    }

    /**
     * Sets the value of the supportedReportSet property.
     *
     * @param value allowed object is
     *              {@link SupportedReportSet }
     */
    public void setSupportedReportSet(SupportedReportSet value) {
        this.supportedReportSet = value;
    }

    /**
     * Gets the value of the quotaAvailableBytes property.
     *
     * @return possible object is
     * {@link QuotaAvailableBytes }
     */
    public QuotaAvailableBytes getQuotaAvailableBytes() {
        return quotaAvailableBytes;
    }

    /**
     * Sets the value of the quotaAvailableBytes property.
     *
     * @param value allowed object is
     *              {@link QuotaAvailableBytes }
     */
    public void setQuotaAvailableBytes(QuotaAvailableBytes value) {
        this.quotaAvailableBytes = value;
    }

    /**
     * Gets the value of the quotaUsedBytes property.
     *
     * @return possible object is
     * {@link QuotaUsedBytes }
     */
    public QuotaUsedBytes getQuotaUsedBytes() {
        return quotaUsedBytes;
    }

    /**
     * Sets the value of the quotaUsedBytes property.
     *
     * @param value allowed object is
     *              {@link QuotaUsedBytes }
     */
    public void setQuotaUsedBytes(QuotaUsedBytes value) {
        this.quotaUsedBytes = value;
    }

    /**
     * Gets the value of the any property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     */
    public List<Element> getAny() {
        if (any == null) {
            any = new ArrayList<Element>();
        }
        return this.any;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Acl getAcl() {
        return acl;
    }

    public void setAcl(Acl acl) {
        this.acl = acl;
    }

    public PrincipalCollectionSet getPrincipalCollectionSet() {
        return principalCollectionSet;
    }

    public void setPrincipalCollectionSet(PrincipalCollectionSet principalCollectionSet) {
        this.principalCollectionSet = principalCollectionSet;
    }

    public PrincipalURL getPrincipalURL() {
        return principalURL;
    }

    public void setPrincipalURL(PrincipalURL principalURL) {
        this.principalURL = principalURL;
    }
}
