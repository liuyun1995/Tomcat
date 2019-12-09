package javax.security.auth.message.callback;

import javax.crypto.SecretKey;
import javax.security.auth.callback.Callback;

/**
 * A callback enabling an authentication module to request a secret key from the
 * runtime, by supplying an alias. Other request types may also be supported.
 */
public class SecretKeyCallback implements Callback {

    private final Request request;
    private SecretKey key;

    public SecretKeyCallback(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public void setKey(SecretKey key) {
        this.key = key;
    }

    public SecretKey getKey() {
        return key;
    }

    public static interface Request {
    }

    public static class AliasRequest implements Request {

        private final String alias;

        public AliasRequest(String alias) {
            this.alias = alias;
        }

        public String getAlias() {
            return alias;
        }
    }
}
