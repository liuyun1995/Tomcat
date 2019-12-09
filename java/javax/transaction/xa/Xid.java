package javax.transaction.xa;

public interface Xid {
    static final int MAXGTRIDSIZE = 64;
    static final int MAXBQUALSIZE = 64;

    int getFormatId();

    byte[] getGlobalTransactionId();

    byte[] getBranchQualifier();
}
