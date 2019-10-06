package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzdno {

    /* renamed from: a */
    private static volatile boolean f28000a = false;

    /* renamed from: b */
    private static final Class<?> f28001b = m29868d();

    /* renamed from: c */
    private static volatile zzdno f28002c;

    /* renamed from: d */
    static final zzdno f28003d = new zzdno(true);

    /* renamed from: e */
    private final Map<C9878a, zzd<?, ?>> f28004e;

    /* renamed from: com.google.android.gms.internal.ads.zzdno$a */
    static final class C9878a {

        /* renamed from: a */
        private final Object f28005a;

        /* renamed from: b */
        private final int f28006b;

        C9878a(Object obj, int i) {
            this.f28005a = obj;
            this.f28006b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f28005a) * 65535) + this.f28006b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C9878a)) {
                return false;
            }
            C9878a aVar = (C9878a) obj;
            if (this.f28005a == aVar.f28005a && this.f28006b == aVar.f28006b) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: d */
    private static Class<?> m29868d() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: b */
    public static zzdno m29866b() {
        return C8901Ho.m22669a();
    }

    /* renamed from: c */
    public static zzdno m29867c() {
        zzdno zzdno = f28002c;
        if (zzdno == null) {
            synchronized (zzdno.class) {
                zzdno = f28002c;
                if (zzdno == null) {
                    zzdno = C8901Ho.m22671b();
                    f28002c = zzdno;
                }
            }
        }
        return zzdno;
    }

    /* renamed from: a */
    static zzdno m29865a() {
        return C9090Qo.m22923a(zzdno.class);
    }

    /* renamed from: a */
    public final <ContainingType extends zzdpk> zzd<ContainingType, ?> mo31590a(ContainingType containingtype, int i) {
        return (zzd) this.f28004e.get(new C9878a(containingtype, i));
    }

    zzdno() {
        this.f28004e = new HashMap();
    }

    private zzdno(boolean z) {
        this.f28004e = Collections.emptyMap();
    }
}
