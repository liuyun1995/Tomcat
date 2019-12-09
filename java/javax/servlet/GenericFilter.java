package javax.servlet;

import java.io.Serializable;
import java.util.Enumeration;

public abstract class GenericFilter implements Filter, FilterConfig, Serializable {

    private static final long serialVersionUID = 1L;

    private volatile FilterConfig filterConfig;


    @Override
    public String getInitParameter(String name) {
        return getFilterConfig().getInitParameter(name);
    }


    @Override
    public Enumeration<String> getInitParameterNames() {
        return getFilterConfig().getInitParameterNames();
    }


    /**
     * Obtain the FilterConfig used to initialise this Filter instance.
     *
     * @return The config previously passed to the {@link #init(FilterConfig)}
     * method
     */
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }


    @Override
    public ServletContext getServletContext() {
        return getFilterConfig().getServletContext();
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        init();
    }


    /**
     * Convenience method for sub-classes to save them having to call
     * <code>super.init(config)</code>. This is a NO-OP by default.
     *
     * @throws ServletException If an exception occurs that interrupts the
     *                          Filter's normal operation
     */
    public void init() throws ServletException {
        // NO-OP
    }


    @Override
    public String getFilterName() {
        return getFilterConfig().getFilterName();
    }
}
