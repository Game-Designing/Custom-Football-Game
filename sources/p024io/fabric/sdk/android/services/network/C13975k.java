package p024io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

/* renamed from: io.fabric.sdk.android.services.network.k */
/* compiled from: SystemKeyStore */
class C13975k {

    /* renamed from: a */
    final KeyStore f42351a;

    /* renamed from: b */
    private final HashMap<Principal, X509Certificate> f42352b;

    public C13975k(InputStream keystoreStream, String passwd) {
        KeyStore trustStore = m44449a(keystoreStream, passwd);
        this.f42352b = m44450a(trustStore);
        this.f42351a = trustStore;
    }

    /* renamed from: b */
    public boolean mo43475b(X509Certificate certificate) {
        X509Certificate trustRoot = (X509Certificate) this.f42352b.get(certificate.getSubjectX500Principal());
        return trustRoot != null && trustRoot.getPublicKey().equals(certificate.getPublicKey());
    }

    /* renamed from: a */
    public X509Certificate mo43474a(X509Certificate certificate) {
        X509Certificate trustRoot = (X509Certificate) this.f42352b.get(certificate.getIssuerX500Principal());
        if (trustRoot == null || trustRoot.getSubjectX500Principal().equals(certificate.getSubjectX500Principal())) {
            return null;
        }
        try {
            certificate.verify(trustRoot.getPublicKey());
            return trustRoot;
        } catch (GeneralSecurityException e) {
            return null;
        }
    }

    /* renamed from: a */
    private HashMap<Principal, X509Certificate> m44450a(KeyStore trustStore) {
        try {
            HashMap<Principal, X509Certificate> trusted = new HashMap<>();
            Enumeration<String> aliases = trustStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate cert = (X509Certificate) trustStore.getCertificate((String) aliases.nextElement());
                if (cert != null) {
                    trusted.put(cert.getSubjectX500Principal(), cert);
                }
            }
            return trusted;
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    private KeyStore m44449a(InputStream keystoreStream, String passwd) {
        BufferedInputStream bin;
        try {
            KeyStore trustStore = KeyStore.getInstance("BKS");
            bin = new BufferedInputStream(keystoreStream);
            trustStore.load(bin, passwd.toCharArray());
            bin.close();
            return trustStore;
        } catch (KeyStoreException kse) {
            throw new AssertionError(kse);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (CertificateException e2) {
            throw new AssertionError(e2);
        } catch (IOException e3) {
            throw new AssertionError(e3);
        } catch (Throwable th) {
            bin.close();
            throw th;
        }
    }
}
