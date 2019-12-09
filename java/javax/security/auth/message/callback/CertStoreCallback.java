package javax.security.auth.message.callback;

import java.security.cert.CertStore;

import javax.security.auth.callback.Callback;

/**
 * Callback that enables a runtime to inform authentication modules of the
 * CertStore to use.
 */
public class CertStoreCallback implements Callback {

    private CertStore certStore;

    public CertStoreCallback() {
    }

    public void setCertStore(CertStore certStore) {
        this.certStore = certStore;
    }

    public CertStore getCertStore() {
        return certStore;
    }
}
