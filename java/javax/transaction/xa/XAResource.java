package javax.transaction.xa;

public interface XAResource {
    void commit(Xid xid, boolean onePhase) throws XAException;

    void end(Xid xid, int flags) throws XAException;

    void forget(Xid xid) throws XAException;

    int getTransactionTimeout() throws XAException;

    boolean isSameRM(XAResource xares) throws XAException;

    int prepare(Xid xid) throws XAException;

    Xid[] recover(int flag) throws XAException;

    void rollback(Xid xid) throws XAException;

    boolean setTransactionTimeout(int seconds) throws XAException;

    void start(Xid xid, int flags) throws XAException;

    public static final int TMENDRSCAN = 0x00800000;
    public static final int TMFAIL = 0x20000000;
    public static final int TMJOIN = 0x00200000;
    public static final int TMNOFLAGS = 0x00000000;
    public static final int TMONEPHASE = 0x40000000;
    public static final int TMRESUME = 0x08000000;
    public static final int TMSTARTRSCAN = 0x01000000;
    public static final int TMSUCCESS = 0x04000000;
    public static final int TMSUSPEND = 0x02000000;
    public static final int XA_RDONLY = 0x00000003;
    public static final int XA_OK = 0;

}
