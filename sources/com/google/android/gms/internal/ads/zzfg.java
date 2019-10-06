package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzfg extends zzfk {
    public zzfg(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 48);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        this.f28409e.mo30774a(zzbz.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.f28410f.invoke(null, new Object[]{this.f28406b.mo31709a()})).booleanValue();
        synchronized (this.f28409e) {
            if (booleanValue) {
                this.f28409e.mo30774a(zzbz.ENUM_TRUE);
            } else {
                this.f28409e.mo30774a(zzbz.ENUM_FALSE);
            }
        }
    }
}
