package javax.transaction;

public class TransactionRolledbackException extends java.rmi.RemoteException {

    private static final long serialVersionUID = -3142798139623020577L;

    public TransactionRolledbackException() {
        super();
    }

    public TransactionRolledbackException(String msg) {
        super(msg);
    }
}
