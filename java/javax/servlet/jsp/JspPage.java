package javax.servlet.jsp;

import javax.servlet.Servlet;

/**
 * The JspPage interface describes the generic interaction that a JSP Page
 * Implementation class must satisfy; pages that use the HTTP protocol
 * are described by the HttpJspPage interface.
 *
 * <p><B>Two plus One Methods</B>
 * <p>
 * The interface defines a protocol with 3 methods; only two of
 * them: jspInit() and jspDestroy() are part of this interface as
 * the signature of the third method: _jspService() depends on
 * the specific protocol used and cannot be expressed in a generic
 * way in Java.
 * <p>
 * A class implementing this interface is responsible for invoking
 * the above methods at the appropriate time based on the
 * corresponding Servlet-based method invocations.
 * <p>
 * The jspInit() and jspDestroy() methods can be defined by a JSP
 * author, but the _jspService() method is defined automatically
 * by the JSP processor based on the contents of the JSP page.
 *
 * <p><B>_jspService()</B>
 * <p>
 * The _jspService()method corresponds to the body of the JSP page. This
 * method is defined automatically by the JSP container and should never
 * be defined by the JSP page author.
 * <p>
 * If a superclass is specified using the extends attribute, that
 * superclass may choose to perform some actions in its service() method
 * before or after calling the _jspService() method.  See using the extends
 * attribute in the JSP_Engine chapter of the JSP specification.
 * <p>
 * The specific signature depends on the protocol supported by the JSP page.
 *
 * <pre>
 * public void _jspService(<em>ServletRequestSubtype</em> request,
 *                             <em>ServletResponseSubtype</em> response)
 *        throws ServletException, IOException;
 * </pre>
 */

public interface JspPage extends Servlet {

    /**
     * The jspInit() method is invoked when the JSP page is initialized. It
     * is the responsibility of the JSP implementation (and of the class
     * mentioned by the extends attribute, if present) that at this point
     * invocations to the getServletConfig() method will return the desired
     * value.
     * <p>
     * A JSP page can override this method by including a definition for it
     * in a declaration element.
     * <p>
     * A JSP page should redefine the init() method from Servlet.
     */
    public void jspInit();

    /**
     * The jspDestroy() method is invoked when the JSP page is about to be
     * destroyed.
     * <p>
     * A JSP page can override this method by including a definition for it
     * in a declaration element.
     * <p>
     * A JSP page should redefine the destroy() method from Servlet.
     */
    public void jspDestroy();

}
