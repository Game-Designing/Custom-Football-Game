package com.paypal.android.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient.Builder;

/* renamed from: com.paypal.android.sdk.ga */
public class C11823ga {

    /* renamed from: a */
    private static final String f37214a = C11823ga.class.getSimpleName();

    /* renamed from: a */
    public static Builder m39143a(int i, boolean z, boolean z2, String str, String str2) {
        StringBuilder sb = new StringBuilder("Creating okhttp client.  networkTimeout=");
        sb.append(i);
        sb.append(", isTrustAll=");
        sb.append(z);
        sb.append(", useSslPinning=");
        sb.append(z2);
        sb.append(", userAgent=");
        sb.append(str);
        sb.append(", baseUrl=");
        sb.append(str2);
        Builder connectionSpecs = new Builder().connectionSpecs(Arrays.asList(new ConnectionSpec[]{ConnectionSpec.MODERN_TLS}));
        connectionSpecs.connectTimeout(Integer.valueOf(i).longValue(), TimeUnit.SECONDS);
        connectionSpecs.readTimeout(Integer.valueOf(i).longValue(), TimeUnit.SECONDS);
        connectionSpecs.interceptors().add(new C11843la(str));
        if (z) {
            try {
                m39145a(connectionSpecs, new X509TrustManager[]{new C11827ha()});
                connectionSpecs.hostnameVerifier(new C11831ia());
            } catch (NoSuchAlgorithmException e) {
                e = e;
                throw new RuntimeException(e);
            } catch (KeyManagementException e2) {
                e = e2;
                throw new RuntimeException(e);
            } catch (KeyStoreException e3) {
                e = e3;
                throw new RuntimeException(e);
            } catch (CertificateException e4) {
                e = e4;
                throw new RuntimeException(e);
            } catch (IOException e5) {
                e = e5;
                throw new RuntimeException(e);
            }
        } else if (z2) {
            m39144a(connectionSpecs);
        } else {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            m39145a(connectionSpecs, instance.getTrustManagers());
        }
        return connectionSpecs;
    }

    /* renamed from: a */
    private static void m39144a(Builder builder) {
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        instance.load(null, null);
        CertificateFactory instance2 = CertificateFactory.getInstance("X.509");
        InputStream a = C11835ja.m39177a();
        try {
            for (Certificate certificate : instance2.generateCertificates(C11835ja.m39177a())) {
                if (certificate instanceof X509Certificate) {
                    instance.setCertificateEntry(((X509Certificate) certificate).getSubjectDN().getName(), certificate);
                }
            }
            TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance3.init(instance);
            m39145a(builder, instance3.getTrustManagers());
        } finally {
            try {
                a.close();
            } catch (IOException | NullPointerException e) {
            }
        }
    }

    /* renamed from: a */
    private static void m39145a(Builder builder, TrustManager[] trustManagerArr) {
        if (trustManagerArr.length != 1 || !(trustManagerArr[0] instanceof X509TrustManager)) {
            StringBuilder sb = new StringBuilder("Unexpected number of trust managers:");
            sb.append(Arrays.toString(trustManagerArr));
            throw new IllegalStateException(sb.toString());
        }
        X509TrustManager x509TrustManager = trustManagerArr[0];
        builder.sslSocketFactory(new C11839ka(x509TrustManager), x509TrustManager);
    }
}
