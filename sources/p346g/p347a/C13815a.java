package p346g.p347a;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Properties;
import p346g.p347a.p356a.C14164v;

/* renamed from: g.a.a */
/* compiled from: JmDNS */
public abstract class C13815a implements Closeable {

    /* renamed from: a */
    public static String f41973a;

    /* renamed from: g.a.a$a */
    /* compiled from: JmDNS */
    public interface C13816a {
        /* renamed from: a */
        void mo43162a(C13815a aVar, Collection<C13821d> collection);
    }

    /* renamed from: a */
    public abstract void mo43160a(String str, C13823e eVar);

    /* renamed from: j */
    public abstract void mo43161j();

    static {
        InputStream inputStream;
        try {
            inputStream = C13815a.class.getClassLoader().getResourceAsStream("version.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            f41973a = properties.getProperty("jmdns.version");
            inputStream.close();
        } catch (Exception e) {
            f41973a = "VERSION MISSING";
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* renamed from: a */
    public static C13815a m43911a(InetAddress addr, String name) throws IOException {
        return new C14164v(addr, name);
    }
}
