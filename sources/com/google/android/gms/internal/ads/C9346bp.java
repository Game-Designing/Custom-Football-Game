package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zze;

/* renamed from: com.google.android.gms.internal.ads.bp */
final class C9346bp implements C9843yp {

    /* renamed from: a */
    private static final C9544kp f22131a = new C9390dp();

    /* renamed from: b */
    private final C9544kp f22132b;

    public C9346bp() {
        this(new C9412ep(C9131So.m22972a(), m23470a()));
    }

    private C9346bp(C9544kp kpVar) {
        zzdod.m29917a(kpVar, "messageInfoFactory");
        this.f22132b = kpVar;
    }

    /* renamed from: a */
    public final <T> C9822xp<T> mo28875a(Class<T> cls) {
        C9864zp.m24399a(cls);
        C9522jp a = this.f22132b.mo28590a(cls);
        if (a.mo28406a()) {
            if (zzdob.class.isAssignableFrom(cls)) {
                return C9610np.m23971a(C9864zp.m24411c(), C8964Ko.m22759a(), a.mo28407b());
            }
            return C9610np.m23971a(C9864zp.m24389a(), C8964Ko.m22760b(), a.mo28407b());
        } else if (zzdob.class.isAssignableFrom(cls)) {
            if (m23471a(a)) {
                return C9588mp.m23891a(cls, a, C9675qp.m24048b(), C9240Xo.m23219b(), C9864zp.m24411c(), C8964Ko.m22759a(), C9500ip.m23700b());
            }
            return C9588mp.m23891a(cls, a, C9675qp.m24048b(), C9240Xo.m23219b(), C9864zp.m24411c(), null, C9500ip.m23700b());
        } else if (m23471a(a)) {
            return C9588mp.m23891a(cls, a, C9675qp.m24047a(), C9240Xo.m23218a(), C9864zp.m24389a(), C8964Ko.m22760b(), C9500ip.m23699a());
        } else {
            return C9588mp.m23891a(cls, a, C9675qp.m24047a(), C9240Xo.m23218a(), C9864zp.m24405b(), null, C9500ip.m23699a());
        }
    }

    /* renamed from: a */
    private static boolean m23471a(C9522jp jpVar) {
        return jpVar.mo28408c() == zze.f28078i;
    }

    /* renamed from: a */
    private static C9544kp m23470a() {
        try {
            return (C9544kp) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return f22131a;
        }
    }
}
