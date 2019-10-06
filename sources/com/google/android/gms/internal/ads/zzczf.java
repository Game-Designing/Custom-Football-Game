package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzczf<E> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final zzbbh<?> f27672a = zzbar.m26376a(null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzbbl f27673b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ScheduledExecutorService f27674c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzczr<E> f27675d;

    public zzczf(zzbbl zzbbl, ScheduledExecutorService scheduledExecutorService, zzczr<E> zzczr) {
        this.f27673b = zzbbl;
        this.f27674c = scheduledExecutorService;
        this.f27675d = zzczr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract String mo31320b(E e);

    /* renamed from: a */
    public final zzczj mo31318a(E e) {
        return new zzczj(this, e);
    }

    /* renamed from: a */
    public final <I> zzczl<I> mo31319a(E e, zzbbh<I> zzbbh) {
        zzczl zzczl = new zzczl(this, e, null, zzbbh, Collections.singletonList(zzbbh), zzbbh, null);
        return zzczl;
    }

    /* renamed from: a */
    public final zzczh mo31317a(E e, zzbbh<?>... zzbbhArr) {
        return new zzczh(this, e, Arrays.asList(zzbbhArr));
    }
}
