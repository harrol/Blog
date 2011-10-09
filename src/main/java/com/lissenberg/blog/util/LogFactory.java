package com.lissenberg.blog.util;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * @author Harro Lissenberg
 */
public class LogFactory {

    @Produces
    @Dependent
    @Log
    public java.util.logging.Logger getLogger(InjectionPoint ip) {
        return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
    }
}
