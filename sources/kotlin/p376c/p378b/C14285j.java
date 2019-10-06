package kotlin.p376c.p378b;

import kotlin.p381e.C14299c;
import kotlin.p381e.C14305h;

/* renamed from: kotlin.c.b.j */
/* compiled from: Reflection */
public class C14285j {

    /* renamed from: a */
    private static final C14286k f43217a;

    /* renamed from: b */
    private static final C14299c[] f43218b = new C14299c[0];

    static {
        C14286k impl;
        try {
            impl = (C14286k) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            impl = null;
        } catch (ClassNotFoundException e2) {
            impl = null;
        } catch (InstantiationException e3) {
            impl = null;
        } catch (IllegalAccessException e4) {
            impl = null;
        }
        f43217a = impl != null ? impl : new C14286k();
    }

    /* renamed from: a */
    public static C14299c m45919a(Class javaClass) {
        return f43217a.mo44458a(javaClass);
    }

    /* renamed from: a */
    public static C14305h m45920a(C14282g p) {
        f43217a.mo44459a(p);
        return p;
    }
}
