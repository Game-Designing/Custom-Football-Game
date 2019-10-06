package com.paypal.android.sdk;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: com.paypal.android.sdk.ka */
public final class C11839ka extends SSLSocketFactory {
    private SSLSocketFactory delegate;

    public C11839ka(TrustManager trustManager) {
        try {
            TrustManager[] trustManagerArr = {trustManager};
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, null);
            this.delegate = instance.getSocketFactory();
        } catch (Exception e) {
            throw new SSLException(e.getMessage());
        }
    }

    /* renamed from: a */
    private static Socket m39192a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            ArrayList arrayList = new ArrayList(Arrays.asList(sSLSocket.getSupportedProtocols()));
            arrayList.retainAll(Arrays.asList(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1"}));
            sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        return socket;
    }

    public final Socket createSocket(String str, int i) {
        Socket createSocket = this.delegate.createSocket(str, i);
        m39192a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        Socket createSocket = this.delegate.createSocket(str, i, inetAddress, i2);
        m39192a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        Socket createSocket = this.delegate.createSocket(inetAddress, i);
        m39192a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        Socket createSocket = this.delegate.createSocket(inetAddress, i, inetAddress2, i2);
        m39192a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        Socket createSocket = this.delegate.createSocket(socket, str, i, z);
        m39192a(createSocket);
        return createSocket;
    }

    public final String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }
}
