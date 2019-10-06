package p363i.p369c.p372c;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p363i.p369c.C14231a;
import p363i.p369c.C14236b;

/* renamed from: i.c.c.c */
/* compiled from: SimpleLoggerFactory */
public class C14249c implements C14231a {

    /* renamed from: a */
    ConcurrentMap<String, C14236b> f43205a = new ConcurrentHashMap();

    public C14249c() {
        C14248b.m45873b();
    }

    /* renamed from: a */
    public C14236b mo44339a(String name) {
        C14236b simpleLogger = (C14236b) this.f43205a.get(name);
        if (simpleLogger != null) {
            return simpleLogger;
        }
        C14236b newInstance = new C14248b(name);
        C14236b oldInstance = (C14236b) this.f43205a.putIfAbsent(name, newInstance);
        return oldInstance == null ? newInstance : oldInstance;
    }
}
