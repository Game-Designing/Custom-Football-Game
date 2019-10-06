package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzfb extends zzfk {

    /* renamed from: i */
    private final boolean f28390i;

    public zzfb(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 61);
        this.f28390i = zzdy.mo31723k();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.f28410f.invoke(null, new Object[]{this.f28406b.mo31709a(), Boolean.valueOf(this.f28390i)})).longValue();
        synchronized (this.f28409e) {
            this.f28409e.mo30765D(longValue);
        }
    }
}
