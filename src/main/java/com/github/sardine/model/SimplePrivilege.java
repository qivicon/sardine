package com.github.sardine.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamInclude;

/**
 * simple marker for privileges
 */
@XStreamAlias("privilege")
@XStreamInclude({Read.class,  All.class, Bind.class, ReadAcl.class, ReadCurrentUserPrivilegeSet.class,
        UnBind.class, Unlock.class, Write.class, WriteContent.class, WriteProperties.class } )
public interface SimplePrivilege {


}
