package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzfe extends zzfk {

    /* renamed from: i */
    private final zzeh f28392i;

    /* renamed from: j */
    private long f28393j;

    public zzfe(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2, zzeh zzeh) {
        super(zzdy, str, str2, zza, i, 53);
        this.f28392i = zzeh;
        if (zzeh != null) {
            this.f28393j = zzeh.mo31730a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        if (this.f28392i != null) {
            this.f28409e.mo30762A(((Long) this.f28410f.invoke(null, new Object[]{Long.valueOf(this.f28393j)})).longValue());
        }
    }
}
