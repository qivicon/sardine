package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamInclude;

/**
 * Created by christoph.schauer on 15.03.2016.
 */
@XStreamAlias("prop")
@XStreamInclude({Remove.class,  Set.class})
public interface PropertyAction {

}
