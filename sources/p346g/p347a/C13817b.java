package p346g.p347a;

import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicReference;
import p346g.p347a.p356a.C14178z;

/* renamed from: g.a.b */
/* compiled from: NetworkTopologyDiscovery */
public interface C13817b {

    /* renamed from: g.a.b$a */
    /* compiled from: NetworkTopologyDiscovery */
    public static final class C13818a {

        /* renamed from: a */
        private static volatile C13817b f41974a;

        /* renamed from: b */
        private static final AtomicReference<C13819a> f41975b = new AtomicReference<>();

        /* renamed from: g.a.b$a$a */
        /* compiled from: NetworkTopologyDiscovery */
        public interface C13819a {
            /* renamed from: a */
            C13817b mo43164a();
        }

        private C13818a() {
        }

        /* renamed from: b */
        protected static C13817b m43917b() {
            C13817b instance = null;
            C13819a delegate = (C13819a) f41975b.get();
            if (delegate != null) {
                instance = delegate.mo43164a();
            }
            return instance != null ? instance : new C14178z();
        }

        /* renamed from: a */
        public static C13817b m43916a() {
            if (f41974a == null) {
                synchronized (C13818a.class) {
                    if (f41974a == null) {
                        f41974a = m43917b();
                    }
                }
            }
            return f41974a;
        }
    }

    /* renamed from: a */
    InetAddress[] mo43163a();
}
