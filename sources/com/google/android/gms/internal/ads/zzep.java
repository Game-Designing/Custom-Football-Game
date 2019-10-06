package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzep extends zzfk {
    public zzep(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        this.f28409e.mo30777b(-1);
        this.f28409e.mo30781c(-1);
        int[] iArr = (int[]) this.f28410f.invoke(null, new Object[]{this.f28406b.mo31709a()});
        synchronized (this.f28409e) {
            this.f28409e.mo30777b((long) iArr[0]);
            this.f28409e.mo30781c((long) iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.f28409e.mo30763B((long) iArr[2]);
            }
        }
    }
}
