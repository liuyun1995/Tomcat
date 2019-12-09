package javax.transaction;

public class InvalidTransactionException extends java.rmi.RemoteException {

    private static final long serialVersionUID = 3597320220337691496L;

    public InvalidTransactionException() {
        super();
    }

    public InvalidTransactionException(String msg) {
        super(msg);
    }
}
