package p363i.p369c.p372c;

import java.io.InputStream;
import java.security.PrivilegedAction;

/* renamed from: i.c.c.a */
/* compiled from: SimpleLogger */
class C14247a implements PrivilegedAction<InputStream> {
    C14247a() {
    }

    public InputStream run() {
        ClassLoader threadCL = Thread.currentThread().getContextClassLoader();
        String str = "simplelogger.properties";
        if (threadCL != null) {
            return threadCL.getResourceAsStream(str);
        }
        return ClassLoader.getSystemResourceAsStream(str);
    }
}
