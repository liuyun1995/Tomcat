package javax.servlet;

import java.util.EventListener;

/**
 * Implementations of this interface receive notifications of changes to the
 * attribute list on the servlet context of a web application. To receive
 * notification events, the implementation class must be configured in the
 * deployment descriptor for the web application.
 *
 * @see ServletContextAttributeEvent
 * @since v 2.3
 */

public interface ServletContextAttributeListener extends EventListener {
    /**
     * Notification that a new attribute was added to the servlet context.
     * Called after the attribute is added.
     * The default implementation is a NO-OP.
     *
     * @param scae Information about the new attribute
     */
    public default void attributeAdded(ServletContextAttributeEvent scae) {
    }

    /**
     * Notification that an existing attribute has been removed from the servlet
     * context. Called after the attribute is removed.
     * The default implementation is a NO-OP.
     *
     * @param scae Information about the removed attribute
     */
    public default void attributeRemoved(ServletContextAttributeEvent scae) {
    }

    /**
     * Notification that an attribute on the servlet context has been replaced.
     * Called after the attribute is replaced.
     * The default implementation is a NO-OP.
     *
     * @param scae Information about the replaced attribute
     */
    public default void attributeReplaced(ServletContextAttributeEvent scae) {
    }
}
