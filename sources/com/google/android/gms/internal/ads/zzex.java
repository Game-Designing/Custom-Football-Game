package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzex extends zzfk {

    /* renamed from: i */
    private static volatile String f28387i = null;

    /* renamed from: j */
    private static final Object f28388j = new Object();

    public zzex(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        this.f28409e.mo30792g("E");
        if (f28387i == null) {
            synchronized (f28388j) {
                if (f28387i == null) {
                    f28387i = (String) this.f28410f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f28409e) {
            this.f28409e.mo30792g(f28387i);
        }
    }
}
