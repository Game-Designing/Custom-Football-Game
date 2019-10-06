package p346g.p347a;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* renamed from: g.a.d */
/* compiled from: ServiceInfo */
public abstract class C13821d implements Cloneable {

    /* renamed from: a */
    public static final byte[] f41976a = new byte[0];

    /* renamed from: g.a.d$a */
    /* compiled from: ServiceInfo */
    public enum C13822a {
        Domain,
        Protocol,
        Application,
        Instance,
        Subtype
    }

    /* renamed from: a */
    public abstract String mo43170a();

    /* renamed from: a */
    public abstract boolean mo43171a(C13821d dVar);

    /* renamed from: b */
    public abstract String mo43172b();

    /* renamed from: c */
    public abstract Inet4Address[] mo43173c();

    /* renamed from: d */
    public abstract Inet6Address[] mo43175d();

    /* renamed from: h */
    public abstract InetAddress[] mo43176h();

    /* renamed from: k */
    public abstract String mo43177k();

    /* renamed from: l */
    public abstract int mo43178l();

    /* renamed from: m */
    public abstract int mo43179m();

    /* renamed from: n */
    public abstract String mo43180n();

    /* renamed from: o */
    public abstract String mo43181o();

    /* renamed from: p */
    public abstract String mo43182p();

    /* renamed from: q */
    public abstract String mo43183q();

    /* renamed from: r */
    public abstract byte[] mo43184r();

    /* renamed from: s */
    public abstract String mo43185s();

    /* renamed from: t */
    public abstract int mo43186t();

    /* renamed from: u */
    public abstract boolean mo43187u();

    /* renamed from: w */
    public abstract boolean mo43188w();

    public C13821d clone() {
        try {
            return (C13821d) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
