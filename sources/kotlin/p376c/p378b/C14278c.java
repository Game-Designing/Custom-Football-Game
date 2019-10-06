package kotlin.p376c.p378b;

import kotlin.p376c.C14270a;
import kotlin.p381e.C14299c;

/* renamed from: kotlin.c.b.c */
/* compiled from: ClassReference.kt */
public final class C14278c implements C14299c<Object>, C14277b {

    /* renamed from: a */
    private final Class<?> f43215a;

    public C14278c(Class<?> jClass) {
        C14281f.m45916b(jClass, "jClass");
        this.f43215a = jClass;
    }

    /* renamed from: a */
    public Class<?> mo44445a() {
        return this.f43215a;
    }

    public boolean equals(Object other) {
        return (other instanceof C14278c) && C14281f.m45915a((Object) C14270a.m45905a(this), (Object) C14270a.m45905a((C14299c) other));
    }

    public int hashCode() {
        return C14270a.m45905a(this).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo44445a().toString());
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
