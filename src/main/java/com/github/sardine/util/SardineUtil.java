package com.github.sardine.util;

import com.github.sardine.model.converter.ElementConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Basic utility code. I borrowed some code from the webdavlib for
 * parsing dates.
 *
 * @author jonstevens
 */
public final class SardineUtil {
    private SardineUtil() {
    }

    private final static String[] SUPPORTED_DATE_FORMATS = new String[]{
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            "EEE, dd MMM yyyy HH:mm:ss zzz",
            "yyyy-MM-dd'T'HH:mm:ss.sss'Z'",
            "yyyy-MM-dd'T'HH:mm:ssZ",
            "EEE MMM dd HH:mm:ss zzz yyyy",
            "EEEEEE, dd-MMM-yy HH:mm:ss zzz",
            "EEE MMMM d HH:mm:ss yyyy"};

    /**
     * Default namespace prefix
     */
    public static final String CUSTOM_NAMESPACE_PREFIX = "s";

    /**
     * Default namespace URI
     */
    public static final String CUSTOM_NAMESPACE_URI = "SAR:";

    /**
     * Default namespace prefix
     */
    public static final String DEFAULT_NAMESPACE_PREFIX = "d";

    /**
     * Default namespace URI
     */
    public static final String DEFAULT_NAMESPACE_URI = "DAV:";

    /**
     * Reusable context for marshalling and unmarshalling
     */

    private static final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


    /**
     * Date formats using for Date parsing.
     */
    private static final List<ThreadLocal<SimpleDateFormat>> DATETIME_FORMATS;

    static {
        List<ThreadLocal<SimpleDateFormat>> l = new ArrayList<ThreadLocal<SimpleDateFormat>>(SUPPORTED_DATE_FORMATS.length);
        for (int i = 0; i < SUPPORTED_DATE_FORMATS.length; i++) {
            l.add(new ThreadLocal<SimpleDateFormat>());
        }
        DATETIME_FORMATS = Collections.unmodifiableList(l);
    }

    /**
     * Loops over all the possible date formats and tries to find the right one.
     *
     * @param value ISO date string
     * @return Null if there is a parsing failure
     */
    public static Date parseDate(String value) {
        if (value == null) {
            return null;
        }
        Date date = null;
        for (int i = 0; i < DATETIME_FORMATS.size(); i++) {
            ThreadLocal<SimpleDateFormat> format = DATETIME_FORMATS.get(i);
            SimpleDateFormat sdf = format.get();
            if (sdf == null) {
                sdf = new SimpleDateFormat(SUPPORTED_DATE_FORMATS[i], Locale.US);
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                format.set(sdf);
            }
            try {
                date = sdf.parse(value);
                break;
            } catch (ParseException e) {
                // We loop through this until we found a valid one.
            }
        }
        return date;
    }

    /**
     * Deserialize an input stream in given object.
     *
     * @param in the stream
     * @param clazz the target class
     * @param <T> the type
     * @return the deserialized object
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(InputStream in, Class<T> clazz) throws IOException {
        XStream xStream = initXStream();
        xStream.processAnnotations(clazz);
        return (T) xStream.fromXML(in);
    }

    /**
     * Create xml from object
     *
     * @param o An object from the model
     * @return The XML string for the WebDAV request
     * @throws RuntimeException When there is a JAXB error
     */
    public static String toXml(Object o) throws IOException {
        XStream xStream = initXStream();
        xStream.processAnnotations(o.getClass());
        return xStream.toXML(o);
    }

    /**
     * @return New XML document from the default document builder factory.
     */
    private static Document createDocument() {
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return builder.newDocument();
    }

    /** */
    public static Map<QName, String> toQName(Map<String, String> setProps) {
        if (setProps == null) {
            return Collections.emptyMap();
        }
        Map<QName, String> result = new HashMap<QName, String>(setProps.size());
        for (Map.Entry<String, String> entry : setProps.entrySet()) {
            result.put(createQNameWithCustomNamespace(entry.getKey()), entry.getValue());
        }
        return result;
    }

    /** */
    public static List<QName> toQName(List<String> removeProps) {
        if (removeProps == null) {
            return Collections.emptyList();
        }
        List<QName> result = new ArrayList<QName>(removeProps.size());
        for (String entry : removeProps) {
            result.add(createQNameWithCustomNamespace(entry));
        }
        return result;
    }

    public static QName toQName(Element element) {
        String namespace = element.getNamespaceURI();
        if (namespace == null) {
            return new QName(SardineUtil.DEFAULT_NAMESPACE_URI,
                    element.getLocalName(),
                    SardineUtil.DEFAULT_NAMESPACE_PREFIX);
        } else if (element.getPrefix() == null) {
            return new QName(element.getNamespaceURI(),
                    element.getLocalName());
        } else {
            return new QName(element.getNamespaceURI(),
                    element.getLocalName(),
                    element.getPrefix());
        }

    }

    /**
     * @param key Local element name.
     */
    public static QName createQNameWithCustomNamespace(String key) {
        return new QName(CUSTOM_NAMESPACE_URI, key, CUSTOM_NAMESPACE_PREFIX);
    }

    /**
     * @param key Local element name.
     */
    public static QName createQNameWithDefaultNamespace(String key) {
        return new QName(DEFAULT_NAMESPACE_URI, key, DEFAULT_NAMESPACE_PREFIX);
    }

    /**
     * @param key Fully qualified element name.
     */
    public static Element createElement(QName key) {
        return createDocument().createElementNS(key.getNamespaceURI(), key.getPrefix() + ":" + key.getLocalPart());
    }

    /**
     * @param key Fully qualified element name.
     */
    public static Element createElement(Element parent, QName key) {
        return parent.getOwnerDocument().createElementNS(key.getNamespaceURI(), key.getPrefix() + ":" + key.getLocalPart());
    }

    /**
     * Creates and configures the XStream object {@link XStream}.
     *
     * @return the XStream object
     */
    private static XStream initXStream() {

        QNameMap map = new QNameMap();
        map.setDefaultNamespace(DEFAULT_NAMESPACE_URI);
        map.setDefaultPrefix(DEFAULT_NAMESPACE_PREFIX);

        // create xstream with staxDriver
        XStream xStream = new XStream(new StaxDriver(map));
        xStream.autodetectAnnotations(true);
        xStream.ignoreUnknownElements();

        // converter for xml dom elements
        xStream.registerConverter(new ElementConverter());

        return xStream;
    }
}
