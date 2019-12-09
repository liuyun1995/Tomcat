package javax.transaction;

public interface TransactionManager {
    public void begin() throws NotSupportedException, SystemException;

    public void commit() throws RollbackException, HeuristicMixedException,
            HeuristicRollbackException, SecurityException,
            IllegalStateException, SystemException;

    public int getStatus() throws SystemException;

    public Transaction getTransaction() throws SystemException;

    public void resume(Transaction tobj) throws InvalidTransactionException,
            IllegalStateException, SystemException;

    public void rollback()
            throws IllegalStateException, SecurityException, SystemException;

    public void setRollbackOnly() throws IllegalStateException, SystemException;

    public void setTransactionTimeout(int seconds) throws SystemException;

    public Transaction suspend() throws SystemException;
}
