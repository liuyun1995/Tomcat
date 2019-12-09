package javax.transaction;

public class RollbackException extends java.lang.Exception {

    private static final long serialVersionUID = 4151607774785285395L;

    public RollbackException() {
        super();
    }

    public RollbackException(String msg) {
        super(msg);
    }
}
