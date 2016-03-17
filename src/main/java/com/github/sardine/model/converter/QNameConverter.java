package com.github.sardine.model.converter;

import com.github.sardine.model.Property;
import com.github.sardine.util.SardineUtil;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import javax.xml.namespace.QName;

/**
 * Converter for {@link QName}.
 *
 * Created by christoph.schauer on 14.03.2016.
 */
public class QNameConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return type.isAssignableFrom(Property.class);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        throw new UnsupportedOperationException("method not implemented");
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Property p = new Property();
        reader.moveDown();
        p.setProperty(new QName(SardineUtil.DEFAULT_NAMESPACE_URI, reader.getNodeName()));
        reader.moveUp();
        return p;
    }
}
