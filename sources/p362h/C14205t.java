package p362h;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* renamed from: h.t */
/* compiled from: Okio */
public final class C14205t {

    /* renamed from: a */
    static final Logger f43101a = Logger.getLogger(C14205t.class.getName());

    private C14205t() {
    }

    /* renamed from: a */
    public static C14194i m45683a(C14180B source) {
        return new C14208w(source);
    }

    /* renamed from: a */
    public static C14193h m45682a(C14179A sink) {
        return new C14206u(sink);
    }

    /* renamed from: a */
    public static C14179A m45677a(OutputStream out) {
        return m45678a(out, new C14182D());
    }

    /* renamed from: a */
    private static C14179A m45678a(OutputStream out, C14182D timeout) {
        if (out == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new C14201p(timeout, out);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C14179A m45679a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            C14186c timeout = m45688c(socket);
            return timeout.sink(m45678a(socket.getOutputStream(), (C14182D) timeout));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    /* renamed from: a */
    public static C14180B m45680a(InputStream in) {
        return m45681a(in, new C14182D());
    }

    /* renamed from: a */
    private static C14180B m45681a(InputStream in, C14182D timeout) {
        if (in == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new C14202q(timeout, in);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: c */
    public static C14180B m45687c(File file) throws FileNotFoundException {
        if (file != null) {
            return m45680a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: b */
    public static C14179A m45685b(File file) throws FileNotFoundException {
        if (file != null) {
            return m45677a((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static C14179A m45676a(File file) throws FileNotFoundException {
        if (file != null) {
            return m45677a((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static C14179A m45675a() {
        return new C14203r();
    }

    /* renamed from: b */
    public static C14180B m45686b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            C14186c timeout = m45688c(socket);
            return timeout.source(m45681a(socket.getInputStream(), (C14182D) timeout));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    /* renamed from: c */
    private static C14186c m45688c(Socket socket) {
        return new C14204s(socket);
    }

    /* renamed from: a */
    static boolean m45684a(AssertionError e) {
        return (e.getCause() == null || e.getMessage() == null || !e.getMessage().contains("getsockname failed")) ? false : true;
    }
}
