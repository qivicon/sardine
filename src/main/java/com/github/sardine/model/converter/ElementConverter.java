package com.github.sardine.model.converter;

import com.github.sardine.util.SardineUtil;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Converter for {@link Element}.
 *
 * Created by christoph.schauer on 16.03.2016.
 */
public class ElementConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return Element.class.isAssignableFrom(type);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        if (source instanceof Element) {
            Element e = (Element) source;
            writer.startNode(e.getLocalName());
            if (e.hasChildNodes()) {
                writer.setValue(e.getFirstChild().getNodeValue());
            }
            writer.endNode();
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        Element element = SardineUtil.createElement(SardineUtil.createQNameWithDefaultNamespace(reader.getNodeName()));
        Text textNode = element.getOwnerDocument().createTextNode(reader.getValue());
        element.appendChild(textNode);

        return element;
    }
}
