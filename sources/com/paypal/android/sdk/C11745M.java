package com.paypal.android.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/* renamed from: com.paypal.android.sdk.M */
public final class C11745M extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f36751a;

    public C11745M(InputStream inputStream) {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, null);
            for (Certificate certificate : CertificateFactory.getInstance("X.509").generateCertificates(inputStream)) {
                if (certificate instanceof X509Certificate) {
                    instance.setCertificateEntry(((X509Certificate) certificate).getSubjectDN().getName(), certificate);
                }
            }
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance2.init(instance);
            SSLContext instance3 = SSLContext.getInstance("TLS");
            instance3.init(null, instance2.getTrustManagers(), null);
            this.f36751a = instance3.getSocketFactory();
            try {
                inputStream.close();
            } catch (IOException | NullPointerException e) {
            }
        } catch (Exception e2) {
            throw new SSLException(e2.getMessage());
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException | NullPointerException e3) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static Socket m38895a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            ArrayList arrayList = new ArrayList(Arrays.asList(sSLSocket.getSupportedProtocols()));
            arrayList.retainAll(Arrays.asList(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1"}));
            sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        return socket;
    }

    public final Socket createSocket(String str, int i) {
        Socket createSocket = this.f36751a.createSocket(str, i);
        m38895a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        Socket createSocket = this.f36751a.createSocket(str, i, inetAddress, i2);
        m38895a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        Socket createSocket = this.f36751a.createSocket(inetAddress, i);
        m38895a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        Socket createSocket = this.f36751a.createSocket(inetAddress, i, inetAddress2, i2);
        m38895a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        Socket createSocket = this.f36751a.createSocket(socket, str, i, z);
        m38895a(createSocket);
        return createSocket;
    }

    public final String[] getDefaultCipherSuites() {
        return this.f36751a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f36751a.getSupportedCipherSuites();
    }
}
