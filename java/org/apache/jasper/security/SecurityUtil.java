package org.apache.jasper.security;

import org.apache.jasper.Constants;

/**
 * Util class for Security related operations.
 */

public final class SecurityUtil {

    private static final boolean packageDefinitionEnabled =
            System.getProperty("package.definition") == null ? false : true;

    /**
     * Return the <code>SecurityManager</code> only if Security is enabled AND
     * package protection mechanism is enabled.
     *
     * @return <code>true</code> if package protection is enabled
     */
    public static boolean isPackageProtectionEnabled() {
        if (packageDefinitionEnabled && Constants.IS_SECURITY_ENABLED) {
            return true;
        }
        return false;
    }
}
