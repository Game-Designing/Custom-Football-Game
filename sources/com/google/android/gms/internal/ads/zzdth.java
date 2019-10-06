package com.google.android.gms.internal.ads;

public final class zzdth<T> implements zzdte<T>, zzdtu<T> {

    /* renamed from: a */
    private static final Object f28300a = new Object();

    /* renamed from: b */
    private volatile zzdtu<T> f28301b;

    /* renamed from: c */
    private volatile Object f28302c = f28300a;

    private zzdth(zzdtu<T> zzdtu) {
        this.f28301b = zzdtu;
    }

    public final T get() {
        T t = this.f28302c;
        if (t == f28300a) {
            synchronized (this) {
                t = this.f28302c;
                if (t == f28300a) {
                    t = this.f28301b.get();
                    T t2 = this.f28302c;
                    if (t2 != f28300a && !(t2 instanceof zzdtn)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.f28302c = t;
                    this.f28301b = null;
                }
            }
        }
        return t;
    }

    /* renamed from: a */
    public static <P extends zzdtu<T>, T> zzdtu<T> m30107a(P p) {
        zzdto.m30113a(p);
        if (p instanceof zzdth) {
            return p;
        }
        return new zzdth(p);
    }

    /* renamed from: b */
    public static <P extends zzdtu<T>, T> zzdte<T> m30108b(P p) {
        if (p instanceof zzdte) {
            return (zzdte) p;
        }
        zzdto.m30113a(p);
        return new zzdth((zzdtu) p);
    }
}
