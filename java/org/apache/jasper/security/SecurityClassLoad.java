package org.apache.jasper.security;

import org.apache.jasper.compiler.Localizer;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

/**
 * Static class used to preload java classes when using the
 * Java SecurityManager so that the defineClassInPackage
 * RuntimePermission does not trigger an AccessControlException.
 */
public final class SecurityClassLoad {

    public static void securityClassLoad(ClassLoader loader) {

        if (System.getSecurityManager() == null) {
            return;
        }

        final String basePackage = "org.apache.jasper.";
        try {
            // Ensure XMLInputFactory is loaded with Tomcat's class loader
            loader.loadClass(basePackage + "compiler.EncodingDetector");

            loader.loadClass(basePackage + "runtime.JspContextWrapper");
            loader.loadClass(basePackage + "runtime.JspFactoryImpl$PrivilegedGetPageContext");
            loader.loadClass(basePackage + "runtime.JspFactoryImpl$PrivilegedReleasePageContext");
            loader.loadClass(basePackage + "runtime.JspFragmentHelper");
            loader.loadClass(basePackage + "runtime.JspRuntimeLibrary");
            loader.loadClass(basePackage + "runtime.PageContextImpl");
            loader.loadClass(basePackage + "runtime.ProtectedFunctionMapper");
            loader.loadClass(basePackage + "runtime.ServletResponseWrapperInclude");
            loader.loadClass(basePackage + "runtime.TagHandlerPool");

            // Trigger loading of class and reading of property
            SecurityUtil.isPackageProtectionEnabled();

            loader.loadClass(basePackage + "servlet.JspServletWrapper");
        } catch (ClassNotFoundException ex) {
            Log log = LogFactory.getLog(SecurityClassLoad.class);
            log.error(Localizer.getMessage("jsp.error.securityPreload"), ex);
        }
    }
}
