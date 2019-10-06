package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;

/* renamed from: com.google.android.gms.internal.measurement.da */
final class C9961da implements C10008va {

    /* renamed from: a */
    private static final C9961da f30101a = new C9961da();

    private C9961da() {
    }

    /* renamed from: a */
    public static C9961da m32082a() {
        return f30101a;
    }

    /* renamed from: b */
    public final boolean mo32718b(Class<?> cls) {
        return zzuo.class.isAssignableFrom(cls);
    }

    /* renamed from: a */
    public final C10006ua mo32717a(Class<?> cls) {
        if (!zzuo.class.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (C10006ua) zzuo.m32517a(cls.asSubclass(zzuo.class)).mo32893a(zze.f30330c, (Object) null, (Object) null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}
