package javax.security.auth.message.callback;

import java.security.KeyStore;

import javax.security.auth.callback.Callback;

/**
 * A Callback enabling an authentication module to request a truststore from the
 * runtime.
 */
public class TrustStoreCallback implements Callback {

    private KeyStore trustStore;

    public void setTrustStore(KeyStore trustStore) {
        this.trustStore = trustStore;
    }

    public KeyStore getTrustStore() {
        return trustStore;
    }
}
