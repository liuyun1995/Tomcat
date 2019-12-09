package javax.transaction;

import javax.transaction.xa.XAResource;

public interface Transaction {

    public void commit() throws RollbackException, HeuristicMixedException,
            HeuristicRollbackException, SecurityException,
            IllegalStateException, SystemException;

    public boolean delistResource(XAResource xaRes, int flag)
            throws IllegalStateException, SystemException;

    public boolean enlistResource(XAResource xaRes)
            throws RollbackException, IllegalStateException, SystemException;

    public int getStatus() throws SystemException;

    public void registerSynchronization(Synchronization sync)
            throws RollbackException, IllegalStateException, SystemException;

    public void rollback() throws IllegalStateException, SystemException;

    public void setRollbackOnly() throws IllegalStateException, SystemException;

}
