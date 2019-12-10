package org.apache.jasper.runtime;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

import javax.el.CompositeELResolver;
import javax.el.ELContext;
import javax.el.ELContextEvent;
import javax.el.ELContextListener;
import javax.el.ELResolver;
import javax.el.ExpressionFactory;
import javax.servlet.ServletContext;
import javax.servlet.jsp.JspApplicationContext;
import javax.servlet.jsp.JspContext;

import org.apache.jasper.Constants;
import org.apache.jasper.compiler.Localizer;
import org.apache.jasper.el.ELContextImpl;
import org.apache.jasper.el.JasperELResolver;

/**
 * Implementation of JspApplicationContext
 *
 * @author Jacob Hookom
 */
public class JspApplicationContextImpl implements JspApplicationContext {

    private static final String KEY = JspApplicationContextImpl.class.getName();

    private final ExpressionFactory expressionFactory =
            ExpressionFactory.newInstance();

    private final List<ELContextListener> contextListeners = new ArrayList<>();

    private final List<ELResolver> resolvers = new ArrayList<>();

    private boolean instantiated = false;

    private ELResolver resolver;

    public JspApplicationContextImpl() {

    }

    @Override
    public void addELContextListener(ELContextListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException(Localizer.getMessage("jsp.error.nullArgument"));
        }
        this.contextListeners.add(listener);
    }

    public static JspApplicationContextImpl getInstance(ServletContext context) {
        if (context == null) {
            throw new IllegalArgumentException(Localizer.getMessage("jsp.error.nullArgument"));
        }
        JspApplicationContextImpl impl = (JspApplicationContextImpl) context
                .getAttribute(KEY);
        if (impl == null) {
            impl = new JspApplicationContextImpl();
            context.setAttribute(KEY, impl);
        }
        return impl;
    }

    public ELContextImpl createELContext(JspContext context) {
        if (context == null) {
            throw new IllegalArgumentException(Localizer.getMessage("jsp.error.nullArgument"));
        }

        // create ELContext for JspContext
        final ELResolver r = this.createELResolver();
        ELContextImpl ctx;
        if (Constants.IS_SECURITY_ENABLED) {
            ctx = AccessController.doPrivileged(
                    new PrivilegedAction<ELContextImpl>() {
                        @Override
                        public ELContextImpl run() {
                            return new ELContextImpl(r);
                        }
                    });
        } else {
            ctx = new ELContextImpl(r);
        }
        ctx.putContext(JspContext.class, context);

        // alert all ELContextListeners
        fireListeners(ctx);

        return ctx;
    }

    protected void fireListeners(ELContext elContext) {
        ELContextEvent event = new ELContextEvent(elContext);
        for (int i = 0; i < this.contextListeners.size(); i++) {
            this.contextListeners.get(i).contextCreated(event);
        }
    }

    private ELResolver createELResolver() {
        this.instantiated = true;
        if (this.resolver == null) {
            CompositeELResolver r = new JasperELResolver(this.resolvers,
                    expressionFactory.getStreamELResolver());
            this.resolver = r;
        }
        return this.resolver;
    }

    @Override
    public void addELResolver(ELResolver resolver) throws IllegalStateException {
        if (resolver == null) {
            throw new IllegalArgumentException(Localizer.getMessage("jsp.error.nullArgument"));
        }
        if (this.instantiated) {
            throw new IllegalStateException(Localizer.getMessage("jsp.error.cannotAddResolver"));
        }
        this.resolvers.add(resolver);
    }

    @Override
    public ExpressionFactory getExpressionFactory() {
        return expressionFactory;
    }

}
