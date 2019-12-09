package javax.el;


public class ELException extends RuntimeException {

    private static final long serialVersionUID = -6228042809457459161L;

    public ELException() {
        super();
    }

    /**
     * Creates an ELException with the provided detail message.
     *
     * @param message the detail message
     */
    public ELException(String message) {
        super(message);
    }

    /**
     * Creates an ELException with the given cause
     *
     * @param cause the originating cause of this exception
     */
    public ELException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates an ELException with the given detail message and root cause.
     *
     * @param message the detail message
     * @param cause   the originating cause of this exception
     */
    public ELException(String message, Throwable cause) {
        super(message, cause);
    }
}
