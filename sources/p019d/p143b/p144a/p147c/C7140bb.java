package p019d.p143b.p144a.p147c;

import java.util.HashMap;
import java.util.Map;

/* renamed from: d.b.a.c.bb */
public class C7140bb {

    /* renamed from: a */
    private static C7140bb f13445a;

    /* renamed from: b */
    private final Map<C7234z, String> f13446b = new HashMap(1);

    /* renamed from: c */
    private final Map<C7234z, Map<String, String>> f13447c = new HashMap(1);

    /* renamed from: d */
    private final Object f13448d = new Object();

    private C7140bb() {
    }

    /* renamed from: a */
    public static synchronized C7140bb m15035a() {
        C7140bb bbVar;
        synchronized (C7140bb.class) {
            if (f13445a == null) {
                f13445a = new C7140bb();
            }
            bbVar = f13445a;
        }
        return bbVar;
    }

    /* renamed from: a */
    public Map<String, String> mo23021a(C7234z zVar) {
        Map<String, String> map;
        synchronized (this.f13448d) {
            map = (Map) this.f13447c.remove(zVar);
        }
        return map;
    }

    /* renamed from: a */
    public void mo23022a(C7234z zVar, String str) {
        synchronized (this.f13448d) {
            this.f13446b.put(zVar, str);
        }
    }

    /* renamed from: a */
    public void mo23023a(C7234z zVar, Map<String, String> map) {
        synchronized (this.f13448d) {
            this.f13447c.put(zVar, map);
        }
    }

    /* renamed from: b */
    public String mo23024b(C7234z zVar) {
        String str;
        synchronized (this.f13448d) {
            str = (String) this.f13446b.remove(zVar);
        }
        return str;
    }
}
