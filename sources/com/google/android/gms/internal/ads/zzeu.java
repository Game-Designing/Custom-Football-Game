package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;

public final class zzeu extends zzfk {

    /* renamed from: i */
    private static volatile Long f28384i = null;

    /* renamed from: j */
    private static final Object f28385j = new Object();

    public zzeu(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 22);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        if (f28384i == null) {
            synchronized (f28385j) {
                if (f28384i == null) {
                    f28384i = (Long) this.f28410f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f28409e) {
            this.f28409e.mo30798k(f28384i.longValue());
        }
    }
}
