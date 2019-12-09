package javax.transaction;

public interface TransactionSynchronizationRegistry {
    Object getTransactionKey();

    void putResource(Object key, Object value);

    Object getResource(Object key);

    void registerInterposedSynchronization(Synchronization sync);

    int getTransactionStatus();

    void setRollbackOnly();

    boolean getRollbackOnly();
}
