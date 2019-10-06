package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zze;

/* renamed from: com.google.android.gms.internal.ads.So */
final class C9131So implements C9544kp {

    /* renamed from: a */
    private static final C9131So f21712a = new C9131So();

    private C9131So() {
    }

    /* renamed from: a */
    public static C9131So m22972a() {
        return f21712a;
    }

    /* renamed from: b */
    public final boolean mo28591b(Class<?> cls) {
        return zzdob.class.isAssignableFrom(cls);
    }

    /* renamed from: a */
    public final C9522jp mo28590a(Class<?> cls) {
        if (!zzdob.class.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (C9522jp) zzdob.m29884a(cls.asSubclass(zzdob.class)).mo30637a(zze.f28072c, (Object) null, (Object) null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}
