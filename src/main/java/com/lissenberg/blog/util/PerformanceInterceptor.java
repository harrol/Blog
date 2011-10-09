package com.lissenberg.blog.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author Harro Lissenberg
 */
@Performance
@Interceptor
public class PerformanceInterceptor {

    @AroundInvoke
    public Object measureDuration(InvocationContext ic) throws Exception {
        Timer t = new Timer();
        try {
            return ic.proceed();
        } finally {
            System.out.println(ic.getMethod().getDeclaringClass().getSimpleName() + "." + ic.getMethod().getName() + " took: " + t.getDuration() + " millis");
        }

    }
}
