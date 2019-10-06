package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class zzfa extends zzfk {

    /* renamed from: i */
    private List<Long> f28389i = null;

    public zzfa(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 31);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        this.f28409e.mo30801m(-1);
        this.f28409e.mo30802n(-1);
        if (this.f28389i == null) {
            this.f28389i = (List) this.f28410f.invoke(null, new Object[]{this.f28406b.mo31709a()});
        }
        List<Long> list = this.f28389i;
        if (list != null && list.size() == 2) {
            synchronized (this.f28409e) {
                this.f28409e.mo30801m(((Long) this.f28389i.get(0)).longValue());
                this.f28409e.mo30802n(((Long) this.f28389i.get(1)).longValue());
            }
        }
    }
}
