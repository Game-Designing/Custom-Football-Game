package p019d.p271g.p272a;

import com.google.android.gms.ads.AdSize;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@Deprecated
/* renamed from: d.g.a.c */
public final class C12722c {

    /* renamed from: a */
    public static final C12722c f39040a;

    /* renamed from: b */
    public static final C12722c f39041b;

    /* renamed from: c */
    public static final C12722c f39042c;

    /* renamed from: d */
    public static final C12722c f39043d;

    /* renamed from: e */
    public static final C12722c f39044e;

    /* renamed from: f */
    public static final C12722c f39045f;

    /* renamed from: g */
    private final AdSize f39046g;

    public C12722c(AdSize adSize) {
        this.f39046g = adSize;
    }

    private C12722c(int i, int i2, String str) {
        this(new AdSize(i, i2));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C12722c)) {
            return false;
        }
        return this.f39046g.equals(((C12722c) obj).f39046g);
    }

    public final int hashCode() {
        return this.f39046g.hashCode();
    }

    /* renamed from: b */
    public final int mo41139b() {
        return this.f39046g.getWidth();
    }

    /* renamed from: a */
    public final int mo41138a() {
        return this.f39046g.getHeight();
    }

    public final String toString() {
        return this.f39046g.toString();
    }

    static {
        String str = "mb";
        f39040a = new C12722c(-1, -2, str);
        f39041b = new C12722c(320, 50, str);
        String str2 = "as";
        f39042c = new C12722c(300, 250, str2);
        f39043d = new C12722c(468, 60, str2);
        f39044e = new C12722c(728, 90, str2);
        f39045f = new C12722c(Opcodes.IF_ICMPNE, 600, str2);
    }
}
