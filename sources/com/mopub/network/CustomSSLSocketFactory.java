package com.mopub.network;

import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Reflection.MethodBuilder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class CustomSSLSocketFactory extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f36349a;

    private CustomSSLSocketFactory() {
    }

    public static CustomSSLSocketFactory getDefault(int handshakeTimeoutMillis) {
        CustomSSLSocketFactory factory = new CustomSSLSocketFactory();
        factory.f36349a = SSLCertificateSocketFactory.getDefault(handshakeTimeoutMillis, null);
        return factory;
    }

    public Socket createSocket() throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f36349a;
        if (sSLSocketFactory != null) {
            Socket socket = sSLSocketFactory.createSocket();
            m38526a(socket);
            return socket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    public Socket createSocket(String host, int i) throws IOException, UnknownHostException {
        SSLSocketFactory sSLSocketFactory = this.f36349a;
        if (sSLSocketFactory != null) {
            Socket socket = sSLSocketFactory.createSocket(host, i);
            m38526a(socket);
            return socket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    public Socket createSocket(String host, int port, InetAddress localhost, int localPort) throws IOException, UnknownHostException {
        SSLSocketFactory sSLSocketFactory = this.f36349a;
        if (sSLSocketFactory != null) {
            Socket socket = sSLSocketFactory.createSocket(host, port, localhost, localPort);
            m38526a(socket);
            return socket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    public Socket createSocket(InetAddress address, int port) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f36349a;
        if (sSLSocketFactory != null) {
            Socket socket = sSLSocketFactory.createSocket(address, port);
            m38526a(socket);
            return socket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    public Socket createSocket(InetAddress address, int port, InetAddress localhost, int localPort) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f36349a;
        if (sSLSocketFactory != null) {
            Socket socket = sSLSocketFactory.createSocket(address, port, localhost, localPort);
            m38526a(socket);
            return socket;
        }
        throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    }

    public String[] getDefaultCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f36349a;
        if (sSLSocketFactory == null) {
            return new String[0];
        }
        return sSLSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f36349a;
        if (sSLSocketFactory == null) {
            return new String[0];
        }
        return sSLSocketFactory.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socketParam, String host, int port, boolean autoClose) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f36349a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        } else if (VERSION.SDK_INT < 23) {
            if (autoClose && socketParam != null) {
                socketParam.close();
            }
            Socket socket = this.f36349a.createSocket(InetAddressUtils.getInetAddressByName(host), port);
            m38526a(socket);
            m38527a(socket, host);
            return socket;
        } else {
            Socket socket2 = sSLSocketFactory.createSocket(socketParam, host, port, autoClose);
            m38526a(socket2);
            return socket2;
        }
    }

    /* renamed from: a */
    private void m38527a(Socket socket, String host) throws IOException {
        Preconditions.checkNotNull(socket);
        SSLSocketFactory sSLSocketFactory = this.f36349a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        } else if (socket instanceof SSLSocket) {
            SSLSocket sslSocket = (SSLSocket) socket;
            m38525a((SSLCertificateSocketFactory) sSLSocketFactory, sslSocket, host);
            m38528a(sslSocket, host);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m38525a(SSLCertificateSocketFactory certificateSocketFactory, SSLSocket sslSocket, String host) {
        Preconditions.checkNotNull(certificateSocketFactory);
        Preconditions.checkNotNull(sslSocket);
        if (VERSION.SDK_INT >= 17) {
            certificateSocketFactory.setHostname(sslSocket, host);
            return;
        }
        try {
            new MethodBuilder(sslSocket, "setHostname").addParam(String.class, host).execute();
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to call setHostname() on the socket");
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m38528a(SSLSocket sslSocket, String host) throws IOException {
        Preconditions.checkNotNull(sslSocket);
        sslSocket.startHandshake();
        if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sslSocket.getSession())) {
            throw new SSLHandshakeException("Server Name Identification failed.");
        }
    }

    /* renamed from: a */
    private void m38526a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sslSocket = (SSLSocket) socket;
            sslSocket.setEnabledProtocols(sslSocket.getSupportedProtocols());
        }
    }
}
