package javax.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Resource {
    public enum AuthenticationType {
        CONTAINER,
        APPLICATION
    }

    public String name() default "";

    /**
     * Uses generics since Common Annotations 1.2.
     *
     * @return The type for instances of this resource
     */
    public Class<?> type() default Object.class;

    public AuthenticationType authenticationType() default AuthenticationType.CONTAINER;

    public boolean shareable() default true;

    public String description() default "";

    public String mappedName() default "";

    /**
     * @return The name of the entry, if any, to use for this resource
     * @since Common Annotations 1.1
     */
    public String lookup() default "";
}
