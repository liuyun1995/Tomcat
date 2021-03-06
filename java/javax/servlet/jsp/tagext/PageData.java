package javax.servlet.jsp.tagext;

import java.io.InputStream;

/**
 * Translation-time information on a JSP page.  The information
 * corresponds to the XML view of the JSP page.
 *
 * <p>
 * Objects of this type are generated by the JSP translator, e.g.
 * when being passed to a TagLibraryValidator instance.
 */

public abstract class PageData {

    /**
     * Sole constructor. (For invocation by subclass constructors,
     * typically implicit.)
     */
    public PageData() {
        // NOOP by default
    }

    /**
     * Returns an input stream on the XML view of a JSP page.
     * The stream is encoded in UTF-8.  Recall that the XML view of a
     * JSP page has the include directives expanded.
     *
     * @return An input stream on the document.
     */
    public abstract InputStream getInputStream();
}
