package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzem extends zzfk {

    /* renamed from: i */
    private static zzfl<String> f28374i = new zzfl<>();

    /* renamed from: j */
    private final Context f28375j;

    public zzem(zzdy zzdy, String str, String str2, C15005zza zza, int i, int i2, Context context) {
        super(zzdy, str, str2, zza, i, 29);
        this.f28375j = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31743a() throws IllegalAccessException, InvocationTargetException {
        this.f28409e.mo30775a("E");
        AtomicReference a = f28374i.mo31748a(this.f28375j.getPackageName());
        if (a.get() == null) {
            synchronized (a) {
                if (a.get() == null) {
                    a.set((String) this.f28410f.invoke(null, new Object[]{this.f28375j}));
                }
            }
        }
        String str = (String) a.get();
        synchronized (this.f28409e) {
            this.f28409e.mo30775a(zzcg.m28402a(str.getBytes(), true));
        }
    }
}
