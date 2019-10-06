package p024io.fabric.sdk.android.services.network;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: io.fabric.sdk.android.services.network.j */
/* compiled from: PinningTrustManager */
class C13974j implements X509TrustManager {

    /* renamed from: a */
    private static final X509Certificate[] f42345a = new X509Certificate[0];

    /* renamed from: b */
    private final TrustManager[] f42346b;

    /* renamed from: c */
    private final C13975k f42347c;

    /* renamed from: d */
    private final long f42348d;

    /* renamed from: e */
    private final List<byte[]> f42349e = new LinkedList();

    /* renamed from: f */
    private final Set<X509Certificate> f42350f = Collections.synchronizedSet(new HashSet());

    public C13974j(C13975k keyStore, C13973i pinningInfoProvider) {
        this.f42346b = m44448a(keyStore);
        this.f42347c = keyStore;
        this.f42348d = pinningInfoProvider.mo19544d();
        for (String pin : pinningInfoProvider.mo19543c()) {
            this.f42349e.add(m44447a(pin));
        }
    }

    /* renamed from: a */
    private TrustManager[] m44448a(C13975k keyStore) {
        try {
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
            tmf.init(keyStore.f42351a);
            return tmf.getTrustManagers();
        } catch (NoSuchAlgorithmException nsae) {
            throw new AssertionError(nsae);
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    private boolean m44446a(X509Certificate certificate) throws CertificateException {
        try {
            byte[] pin = MessageDigest.getInstance("SHA1").digest(certificate.getPublicKey().getEncoded());
            for (byte[] validPin : this.f42349e) {
                if (Arrays.equals(validPin, pin)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException nsae) {
            throw new CertificateException(nsae);
        }
    }

    /* renamed from: a */
    private void m44445a(X509Certificate[] chain, String authType) throws CertificateException {
        TrustManager[] trustManagerArr = this.f42346b;
        int length = trustManagerArr.length;
        for (int i = 0; i < length; i++) {
            ((X509TrustManager) trustManagerArr[i]).checkServerTrusted(chain, authType);
        }
    }

    /* renamed from: a */
    private void m44444a(X509Certificate[] chain) throws CertificateException {
        if (this.f42348d == -1 || System.currentTimeMillis() - this.f42348d <= 15552000000L) {
            X509Certificate[] cleanChain = C13965a.m44426a(chain, this.f42347c);
            int length = cleanChain.length;
            int i = 0;
            while (i < length) {
                if (!m44446a(cleanChain[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pins are stale, (");
        sb.append(System.currentTimeMillis() - this.f42348d);
        sb.append(" millis vs ");
        sb.append(15552000000L);
        sb.append(" millis) falling back to system trust.");
        e.mo43321a("Fabric", sb.toString());
    }

    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        if (!this.f42350f.contains(chain[0])) {
            m44445a(chain, authType);
            m44444a(chain);
            this.f42350f.add(chain[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f42345a;
    }

    /* renamed from: a */
    private byte[] m44447a(String s) {
        int len = s.length();
        byte[] data = new byte[(len / 2)];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
