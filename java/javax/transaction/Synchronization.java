package javax.transaction;

public interface Synchronization {
    public void beforeCompletion();

    public void afterCompletion(int status);
}
