package org.apache.tomcat;

import java.lang.reflect.InvocationTargetException;

import javax.naming.NamingException;

public interface InstanceManager {

    Object newInstance(Class<?> clazz) throws IllegalAccessException, InvocationTargetException,
            NamingException, InstantiationException, IllegalArgumentException,
            NoSuchMethodException, SecurityException;

    Object newInstance(String className) throws IllegalAccessException, InvocationTargetException,
            NamingException, InstantiationException, ClassNotFoundException,
            IllegalArgumentException, NoSuchMethodException, SecurityException;

    Object newInstance(String fqcn, ClassLoader classLoader) throws IllegalAccessException,
            InvocationTargetException, NamingException, InstantiationException,
            ClassNotFoundException, IllegalArgumentException, NoSuchMethodException,
            SecurityException;

    void newInstance(Object o)
            throws IllegalAccessException, InvocationTargetException, NamingException;

    void destroyInstance(Object o) throws IllegalAccessException, InvocationTargetException;

    /**
     * Called by the component using the InstanceManager periodically to perform
     * any regular maintenance that might be required. By default, this method
     * is a NO-OP.
     */
    default void backgroundProcess() {
        // NO-OP by default
    }
}
