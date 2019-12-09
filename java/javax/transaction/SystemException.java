package javax.transaction;

public class SystemException extends java.lang.Exception {

    private static final long serialVersionUID = 8615483418828223571L;

    public int errorCode;

    public SystemException() {
        super();
    }

    public SystemException(String s) {
        super(s);
    }

    public SystemException(int errcode) {
        super();
        errorCode = errcode;
    }

}
