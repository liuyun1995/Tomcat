package javax.transaction;

public class TransactionRequiredException extends java.rmi.RemoteException {

    private static final long serialVersionUID = -1898806419937446439L;

    public TransactionRequiredException() {
        super();
    }

    public TransactionRequiredException(String msg) {
        super(msg);
    }
}
