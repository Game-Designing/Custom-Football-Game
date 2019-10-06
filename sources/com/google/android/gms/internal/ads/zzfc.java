package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzfc extends zzfk {

    /* renamed from: i */
    private final StackTraceElement[] f28391i;

    public zzfc(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzdy, str, str2, zza, i, 45);
        this.f28391i = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        zzbz zzbz;
        StackTraceElement[] stackTraceElementArr = this.f28391i;
        if (stackTraceElementArr != null) {
            zzdw zzdw = new zzdw((String) this.f28410f.invoke(null, new Object[]{stackTraceElementArr}));
            synchronized (this.f28409e) {
                this.f28409e.mo30812x(zzdw.f28318b.longValue());
                if (zzdw.f28319c.booleanValue()) {
                    C15005zza zza = this.f28409e;
                    if (zzdw.f28320d.booleanValue()) {
                        zzbz = zzbz.ENUM_FALSE;
                    } else {
                        zzbz = zzbz.ENUM_TRUE;
                    }
                    zza.mo30782c(zzbz);
                } else {
                    this.f28409e.mo30782c(zzbz.ENUM_FAILURE);
                }
            }
        }
    }
}
