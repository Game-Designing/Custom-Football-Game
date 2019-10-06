package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;

/* renamed from: com.google.android.gms.internal.measurement.na */
final class C9991na implements C9908Ga {

    /* renamed from: a */
    private static final C10008va f30146a = new C9994oa();

    /* renamed from: b */
    private final C10008va f30147b;

    public C9991na() {
        this(new C9996pa(C9961da.m32082a(), m32172a()));
    }

    private C9991na(C10008va vaVar) {
        zzuq.m32542a(vaVar, "messageInfoFactory");
        this.f30147b = vaVar;
    }

    /* renamed from: a */
    public final <T> C9906Fa<T> mo32561a(Class<T> cls) {
        C9910Ha.m31802a(cls);
        C10006ua a = this.f30147b.mo32717a(cls);
        if (a.mo32550g()) {
            if (zzuo.class.isAssignableFrom(cls)) {
                return C10014ya.m32247a(C9910Ha.m31814c(), C9942Y.m31962a(), a.mo32549f());
            }
            return C10014ya.m32247a(C9910Ha.m31794a(), C9942Y.m31963b(), a.mo32549f());
        } else if (zzuo.class.isAssignableFrom(cls)) {
            if (m32173a(a)) {
                return C10012xa.m32215a(cls, a, C9898Ba.m31765b(), C9976ia.m32104b(), C9910Ha.m31814c(), C9942Y.m31962a(), C10004ta.m32198b());
            }
            return C10012xa.m32215a(cls, a, C9898Ba.m31765b(), C9976ia.m32104b(), C9910Ha.m31814c(), null, C10004ta.m32198b());
        } else if (m32173a(a)) {
            return C10012xa.m32215a(cls, a, C9898Ba.m31764a(), C9976ia.m32103a(), C9910Ha.m31794a(), C9942Y.m31963b(), C10004ta.m32197a());
        } else {
            return C10012xa.m32215a(cls, a, C9898Ba.m31764a(), C9976ia.m32103a(), C9910Ha.m31808b(), null, C10004ta.m32197a());
        }
    }

    /* renamed from: a */
    private static boolean m32173a(C10006ua uaVar) {
        return uaVar.mo32551h() == zze.f30336i;
    }

    /* renamed from: a */
    private static C10008va m32172a() {
        try {
            return (C10008va) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return f30146a;
        }
    }
}
