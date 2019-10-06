package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzff extends zzfk {

    /* renamed from: i */
    private static volatile Long f28394i = null;

    /* renamed from: j */
    private static final Object f28395j = new Object();

    public zzff(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 33);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        if (f28394i == null) {
            synchronized (f28395j) {
                if (f28394i == null) {
                    f28394i = (Long) this.f28410f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f28409e) {
            this.f28409e.mo30803o(f28394i.longValue());
        }
    }
}
