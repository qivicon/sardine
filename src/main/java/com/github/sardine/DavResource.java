/*
 * Copyright 2009-2011 Jon Stevens et al. Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under the License.
 */

package com.github.sardine;

import com.github.sardine.model.*;
import com.github.sardine.util.SardineUtil;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.logging.Logger;

/**
 * Describes a resource on a remote server. This could be a directory or an actual file.
 *
 * @author jonstevens
 */
public class DavResource
{
	private static final Logger log = Logger.getLogger(DavResource.class.getName());

	/**
	 * The default content-type if is not set in
	 * the {@link com.github.sardine.model.Multistatus} response.
	 */
	public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";

	/**
	 * The default content-lenght if is not set in
	 * the {@link com.github.sardine.model.Multistatus} response.
	 */
	public static final long DEFAULT_CONTENT_LENGTH = -1;

	/**
	 * content-type for {@link com.github.sardine.model.Collection}.
	 */
	public static final String HTTPD_UNIX_DIRECTORY_CONTENT_TYPE = "httpd/unix-directory";

	/**
	 * Path component seperator
	 */
	private static final String SEPARATOR = "/";

	private final URI href;
	private final Date creation;
	private final Date modified;
	private final String contentType;
	private final String etag;
	private final String displayName;
	private final List<QName> resourceTypes;
	private final String contentLanguage;
	private final Long contentLength;
	private final List<QName> supportedReports;
	private final Map<QName, String> customProps;

	/**
	 * Represents a webdav response block.
	 *
	 * @param href URI to the resource as returned from the server
	 * @throws java.net.URISyntaxException If parsing the href from the response element fails
	 */
	protected DavResource(String href, Date creation, Date modified, String contentType,
						  Long contentLength, String etag, String displayName, List<QName> resourceTypes,
						  String contentLanguage, List<QName> supportedReports, Map<QName, String> customProps)
			throws URISyntaxException
	{
		this.href = new URI(href);
		this.creation = creation;
		this.modified = modified;
		this.contentType = contentType;
		this.contentLength = contentLength;
		this.etag = etag;
		this.displayName = displayName;
		this.resourceTypes = resourceTypes;
		this.contentLanguage = contentLanguage;
		this.supportedReports = supportedReports;
		this.customProps = customProps;
	}

	/**
	 * Converts the given {@link Response} to a {@link com.github.sardine.DavResource}.
	 *
	 * @param response The response complex type of the multistatus
	 * @throws java.net.URISyntaxException If parsing the href from the response element fails
	 */
	public DavResource(Response response) throws URISyntaxException
	{
		this.href = new URI(response.getHref().get(0));
		this.creation = SardineUtil.parseDate(this.getCreationDate(response));
		this.modified = SardineUtil.parseDate(this.getModifiedDate(response));
		this.contentType = this.getContentType(response);
		this.contentLength = this.getContentLength(response);
		this.etag = this.getEtag(response);
		this.displayName = this.getDisplayName(response);
		this.resourceTypes = this.getResourceTypes(response);
		this.contentLanguage = this.getContentLanguage(response);
		this.supportedReports = this.getSupportedReports(response);
		this.customProps = this.getCustomProps(response);
	}

	/**
	 * Retrieves modifieddate from props. If it is not available return null.
	 *
	 * @param response The response complex type of the multistatus
	 * @return Null if not found in props
	 */
	private String getModifiedDate(Response response)
	{
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return null;
		}
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				List<String> glm = propstat.getProp().getGetlastmodified();
				if ((glm != null) && (glm.size() == 1))
				{
					return glm.get(0);
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves creationdate from props. If it is not available return null.
	 *
	 * @param response The response complex type of the multistatus
	 * @return Null if not found in props
	 */
	private String getCreationDate(Response response)
	{
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return null;
		}
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				List<String> gcd = propstat.getProp().getCreationdate();
				if ((gcd != null) && (gcd.size() == 1))
				{
					return gcd.get(0);
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves the content-type from prop or set it to {@link #DEFAULT_CONTENT_TYPE}. If isDirectory always set the content-type to
	 * {@link #HTTPD_UNIX_DIRECTORY_CONTENT_TYPE}.
	 *
	 * @param response The response complex type of the multistatus
	 * @return the content type.
	 */
	private String getContentType(Response response)
	{
		// Make sure that directories have the correct content type.
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return null;
		}
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				Resourcetype resourcetype = propstat.getProp().getResourcetype();
				if ((resourcetype != null) && (resourcetype.getCollection() != null))
				{
					// Need to correct the contentType to identify as a directory.
					return HTTPD_UNIX_DIRECTORY_CONTENT_TYPE;
				}
				else
				{
					List<String> gtt = propstat.getProp().getGetcontenttype();
					if ((gtt != null) && (gtt.size() == 1))
					{
						return gtt.get(0);
					}
				}
			}
		}
		return DEFAULT_CONTENT_TYPE;
	}

	/**
	 * Retrieves content-length from props. If it is not available return {@link #DEFAULT_CONTENT_LENGTH}.
	 *
	 * @param response The response complex type of the multistatus
	 * @return contentlength
	 */
	private long getContentLength(Response response)
	{
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return DEFAULT_CONTENT_LENGTH;
		}
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				List<String> gcl = propstat.getProp().getGetcontentlength();
				if ((gcl != null) && (gcl.size() == 1))
				{
					try
					{
						return Long.parseLong(gcl.get(0));
					}
					catch (NumberFormatException e)
					{
						log.warning(String.format("Failed to parse content length %s", gcl.get(0)));
					}
				}
			}
		}
		return DEFAULT_CONTENT_LENGTH;
	}

	/**
	 * Retrieves content-length from props. If it is not available return {@link #DEFAULT_CONTENT_LENGTH}.
	 *
	 * @param response The response complex type of the multistatus
	 * @return contentlength
	 */
	private String getEtag(Response response)
	{
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return null;
		}
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				List<String> e = propstat.getProp().getGetetag();
				if ((e != null) && (e.size() == 1))
				{
					return e.get(0);
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves the content-language from prop.
	 *
	 * @param response The response complex type of the multistatus
	 * @return the content language; {@code null} if it is not avaialble
	 */
	private String getContentLanguage(Response response)
	{
		// Make sure that directories have the correct content type.
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return null;
		}
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				Resourcetype resourcetype = propstat.getProp().getResourcetype();
				if ((resourcetype != null) && (resourcetype.getCollection() != null))
				{
					// Need to correct the contentType to identify as a directory.
					return HTTPD_UNIX_DIRECTORY_CONTENT_TYPE;
				}
				else
				{
					List<String> gtl = propstat.getProp().getGetcontentlanguage();
					if ((gtl != null) && (gtl.size() == 1))
					{
						return gtl.get(0);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves displayName from props.
	 *
	 * @param response The response complex type of the multistatus
	 * @return the display name; {@code null} if it is not available
	 */
	private String getDisplayName(Response response)
	{
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return null;
		}
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				List<String> dn = propstat.getProp().getDisplayname();
				if ((dn != null) && (dn.size() == 1))
				{
					return dn.get(0);
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves resourceType from props.
	 *
	 * @param response The response complex type of the multistatus
	 * @return the list of resource types; {@code Collections.emptyList()} if it is not provided
	 */
	private List<QName> getResourceTypes(Response response)
	{
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return Collections.emptyList();
		}
		List<QName> resourceTypes = new ArrayList<QName>();
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				Resourcetype rt = propstat.getProp().getResourcetype();
				if (rt != null)
				{
					if (rt.getCollection() != null)
					{
						resourceTypes.add(SardineUtil.createQNameWithDefaultNamespace("collection"));
					}
					if (rt.getPrincipal() != null)
					{
						resourceTypes.add(SardineUtil.createQNameWithDefaultNamespace("principal"));
					}
					for (Element element : rt.getAny())
					{
						resourceTypes.add(SardineUtil.toQName(element));
					}
				}
			}
		}
		return resourceTypes;
	}

	/**
	 * Retrieves resourceType from props.
	 *
	 * @param response The response complex type of the multistatus
	 * @return the list of resource types; {@code Collections.emptyList()} if it is not provided
	 */
	private List<QName> getSupportedReports(Response response)
	{
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return Collections.emptyList();
		}
		List<QName> supportedReports = new ArrayList<QName>();
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				SupportedReportSet srs = propstat.getProp().getSupportedReportSet();
				if (srs != null)
				{
					for (SupportedReport sr : srs.getSupportedReport())
					{
						Report report = sr.getReport();
						if (report != null && report.getAny() != null)
						{
							supportedReports.add(SardineUtil.toQName(report.getAny()));
						}
					}
				}
			}
		}
		return supportedReports;
	}

	/**
	 * Creates a simple complex Map from the given custom properties of a response.
	 * This implementation does take namespaces into account.
	 *
	 * @param response The response complex type of the multistatus
	 * @return Custom properties
	 */
	private Map<QName, String> getCustomProps(Response response)
	{
		List<Propstat> list = response.getPropstat();
		if (list.isEmpty())
		{
			return null;
		}
		Map<QName, String> customPropsMap = new HashMap<QName, String>();
		for (Propstat propstat : list)
		{
			if (propstat.getProp() != null) {
				List<Element> props = propstat.getProp().getAny();
				for (Element element : props)
				{
					customPropsMap.put(SardineUtil.toQName(element), element.getTextContent());
				}
			}
		}
		return customPropsMap;
	}

	/**
	 * @return Timestamp
	 */
	public Date getCreation()
	{
		return this.creation;
	}

	/**
	 * @return Timestamp
	 */
	public Date getModified()
	{
		return this.modified;
	}

	/**
	 * @return MIME Type
	 */
	public String getContentType()
	{
		return this.contentType;
	}

	/**
	 * @return Size
	 */
	public Long getContentLength()
	{
		return this.contentLength;
	}

	/**
	 * @return Fingerprint
	 */
	public String getEtag()
	{
		return this.etag;
	}

	/**
	 * @return Content language
	 */
	public String getContentLanguage()
	{
		return this.contentLanguage;
	}

	/**
	 * @return Display name
	 */
	public String getDisplayName()
	{
		return this.displayName;
	}

	/**
	 * @return Resource types
	 */
	public List<QName> getResourceTypes()
	{
		return this.resourceTypes;
	}

	/**
	 * @return Resource types
	 */
	public List<QName> getSupportedReports()
	{
		return this.supportedReports;
	}

	/**
	 * Implementation assumes that every resource with a content type of <code>httpd/unix-directory</code> is a directory.
	 *
	 * @return True if this resource denotes a directory
	 */
	public boolean isDirectory()
	{
		return HTTPD_UNIX_DIRECTORY_CONTENT_TYPE.equals(this.contentType);
	}

	/**
	 * @return Additional metadata. This implementation does not take namespaces into account.
	 */
	public Map<String, String> getCustomProps()
	{
		Map<String, String> local = new HashMap<String, String>();
		Map<QName, String> properties = this.getCustomPropsNS();
		for (QName key : properties.keySet())
		{
			local.put(key.getLocalPart(), properties.get(key));
		}
		return local;
	}

	/**
	 * @return Additional metadata with namespace informations
	 */
	public Map<QName, String> getCustomPropsNS()
	{
		return this.customProps;
	}

	/**
	 * @return URI of the resource.
	 */
	public URI getHref()
	{
		return this.href;
	}

	/**
	 * Last path component.
	 *
	 * @return The name of the resource URI decoded. An empty string if this resource denotes a directory.
	 * @see #getHref()
	 */
	public String getName()
	{
		String path = this.href.getPath();
		try
		{
			if (path.endsWith(SEPARATOR))
			{
				path = path.substring(0, path.length() - 1);
			}
			return path.substring(path.lastIndexOf('/') + 1);
		}
		catch (StringIndexOutOfBoundsException e)
		{
			log.warning(String.format("Failed to parse name from path %s", path));
			return null;
		}
	}

	/**
	 * @return Path component of the URI of the resource.
	 * @see #getHref()
	 */
	public String getPath()
	{
		return this.href.getPath();
	}

	/**
	 * @see #getPath()
	 */
	@Override
	public String toString()
	{
		return this.getPath();
	}
}
