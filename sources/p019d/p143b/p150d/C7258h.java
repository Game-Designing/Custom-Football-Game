package p019d.p143b.p150d;

import java.util.Locale;

/* renamed from: d.b.d.h */
public class C7258h {

    /* renamed from: a */
    public static final C7258h f14102a = new C7258h("REGULAR");

    /* renamed from: b */
    public static final C7258h f14103b = new C7258h("VIDEOA");

    /* renamed from: c */
    public static final C7258h f14104c = new C7258h("NATIVE");

    /* renamed from: d */
    private final String f14105d;

    public C7258h(String str) {
        this.f14105d = str;
    }

    /* renamed from: a */
    public static C7258h m15781a(String str) {
        return str.toUpperCase(Locale.ENGLISH).equals(f14103b.mo23476a()) ? f14103b : f14102a;
    }

    /* renamed from: a */
    public String mo23476a() {
        return this.f14105d.toUpperCase(Locale.ENGLISH);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || C7258h.class != obj.getClass()) {
            return false;
        }
        C7258h hVar = (C7258h) obj;
        String str = this.f14105d;
        if (str == null ? hVar.f14105d != null : !str.equals(hVar.f14105d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f14105d;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return mo23476a();
    }
}
