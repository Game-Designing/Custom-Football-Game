package p019d.p273h.p276c.p282f;

import java.util.Map;
import org.json.JSONObject;

/* renamed from: d.h.c.f.f */
/* compiled from: GeneralProperties */
public class C12870f {

    /* renamed from: a */
    private static C12870f f39604a;

    /* renamed from: b */
    private JSONObject f39605b = new JSONObject();

    private C12870f() {
    }

    /* renamed from: a */
    public static synchronized C12870f m41821a() {
        C12870f fVar;
        synchronized (C12870f.class) {
            if (f39604a == null) {
                f39604a = new C12870f();
            }
            fVar = f39604a;
        }
        return fVar;
    }

    /* renamed from: a */
    public synchronized void mo41642a(Map<String, Object> properties) {
        if (properties != null) {
            for (String key : properties.keySet()) {
                mo41641a(key, properties.get(key));
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo41641a(String key, Object value) {
        try {
            this.f39605b.put(key, value);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public synchronized JSONObject mo41643b() {
        return this.f39605b;
    }
}
