package p019d.p135a.p136a.p138b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: d.a.a.b.u */
/* compiled from: TLSSocketFactory */
public class C6876u extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f12597a;

    public C6876u() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext context = SSLContext.getInstance("TLSv1.2");
        context.init(null, null, null);
        this.f12597a = context.getSocketFactory();
    }

    public String[] getDefaultCipherSuites() {
        return this.f12597a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f12597a.getSupportedCipherSuites();
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = this.f12597a.createSocket();
        m13960a(createSocket);
        return createSocket;
    }

    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        Socket createSocket = this.f12597a.createSocket(s, host, port, autoClose);
        m13960a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String host, int port) throws IOException {
        Socket createSocket = this.f12597a.createSocket(host, port);
        m13960a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        Socket createSocket = this.f12597a.createSocket(host, port, localHost, localPort);
        m13960a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket createSocket = this.f12597a.createSocket(host, port);
        m13960a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        Socket createSocket = this.f12597a.createSocket(address, port, localAddress, localPort);
        m13960a(createSocket);
        return createSocket;
    }

    /* renamed from: a */
    private Socket m13960a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return socket;
    }
}
