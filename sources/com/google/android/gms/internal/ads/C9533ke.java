package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.google.android.gms.internal.ads.ke */
final class C9533ke extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f22642a = ((SSLSocketFactory) SSLSocketFactory.getDefault());

    /* renamed from: b */
    private final /* synthetic */ C9511je f22643b;

    C9533ke(C9511je jeVar) {
        this.f22643b = jeVar;
    }

    public final String[] getDefaultCipherSuites() {
        return this.f22642a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f22642a.getSupportedCipherSuites();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.f22642a.createSocket(socket, str, i, z);
        m23742a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(String str, int i) throws IOException {
        Socket createSocket = this.f22642a.createSocket(str, i);
        m23742a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket createSocket = this.f22642a.createSocket(str, i, inetAddress, i2);
        m23742a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.f22642a.createSocket(inetAddress, i);
        m23742a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.f22642a.createSocket(inetAddress, i, inetAddress2, i2);
        m23742a(createSocket);
        return createSocket;
    }

    /* renamed from: a */
    private final Socket m23742a(Socket socket) throws SocketException {
        if (this.f22643b.f22607q > 0) {
            socket.setReceiveBufferSize(this.f22643b.f22607q);
        }
        this.f22643b.m23713a(socket);
        return socket;
    }
}
