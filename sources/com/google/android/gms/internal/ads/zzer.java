package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzer extends zzfk {

    /* renamed from: i */
    private long f28381i;

    public zzer(zzdy zzdy, String str, String str2, C15005zza zza, long j, int i, int i2) {
        super(zzdy, str, str2, zza, i, 25);
        this.f28381i = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.f28410f.invoke(null, new Object[0])).longValue();
        synchronized (this.f28409e) {
            this.f28409e.mo30768G(longValue);
            if (this.f28381i != 0) {
                this.f28409e.mo30795i(longValue - this.f28381i);
                this.f28409e.mo30799l(this.f28381i);
            }
        }
    }
}
