package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzczl<O> {

    /* renamed from: a */
    private final E f27681a;

    /* renamed from: b */
    private final String f27682b;

    /* renamed from: c */
    private final zzbbh<?> f27683c;

    /* renamed from: d */
    private final List<zzbbh<?>> f27684d;

    /* renamed from: e */
    private final zzbbh<O> f27685e;

    /* renamed from: f */
    final /* synthetic */ zzczf f27686f;

    private zzczl(zzczf zzczf, E e, String str, zzbbh<?> zzbbh, List<zzbbh<?>> list, zzbbh<O> zzbbh2) {
        this.f27686f = zzczf;
        this.f27681a = e;
        this.f27682b = str;
        this.f27683c = zzbbh;
        this.f27684d = list;
        this.f27685e = zzbbh2;
    }

    /* renamed from: a */
    public final zzczl<O> mo31333a(String str) {
        zzczl zzczl = new zzczl(this.f27686f, this.f27681a, str, this.f27683c, this.f27684d, this.f27685e);
        return zzczl;
    }

    /* renamed from: a */
    public final <O2> zzczl<O2> mo31329a(zzczc<O, O2> zzczc) {
        return mo31327a((zzbal<O, O2>) new C9777vm<O,O2>(zzczc));
    }

    /* renamed from: a */
    public final <O2> zzczl<O2> mo31327a(zzbal<O, O2> zzbal) {
        return m29039a(zzbal, (Executor) this.f27686f.f27673b);
    }

    /* renamed from: a */
    private final <O2> zzczl<O2> m29039a(zzbal<O, O2> zzbal, Executor executor) {
        zzczl zzczl = new zzczl(this.f27686f, this.f27681a, this.f27682b, this.f27683c, this.f27684d, zzbar.m26379a(this.f27685e, zzbal, executor));
        return zzczl;
    }

    /* renamed from: a */
    public final <O2> zzczl<O2> mo31328a(zzbbh<O2> zzbbh) {
        return m29039a((zzbal<O, O2>) new C9798wm<O,O2>(zzbbh), zzbbm.f25065b);
    }

    /* renamed from: a */
    public final <T extends Throwable> zzczl<O> mo31331a(Class<T> cls, zzczc<T, O> zzczc) {
        return mo31330a(cls, (zzbal<T, O>) new C9819xm<T,O>(zzczc));
    }

    /* renamed from: a */
    public final <T extends Throwable> zzczl<O> mo31330a(Class<T> cls, zzbal<T, O> zzbal) {
        zzczf zzczf = this.f27686f;
        zzczl zzczl = new zzczl(zzczf, this.f27681a, this.f27682b, this.f27683c, this.f27684d, zzbar.m26381a(this.f27685e, cls, zzbal, (Executor) zzczf.f27673b));
        return zzczl;
    }

    /* renamed from: a */
    public final zzczl<O> mo31326a(long j, TimeUnit timeUnit) {
        zzczf zzczf = this.f27686f;
        zzczl zzczl = new zzczl(zzczf, this.f27681a, this.f27682b, this.f27683c, this.f27684d, zzbar.m26378a(this.f27685e, j, timeUnit, zzczf.f27674c));
        return zzczl;
    }

    /* renamed from: a */
    public final zzcze<E, O> mo31325a() {
        E e = this.f27681a;
        String str = this.f27682b;
        if (str == null) {
            str = this.f27686f.mo31320b(e);
        }
        zzcze<E, O> zzcze = new zzcze<>(e, str, this.f27685e);
        this.f27686f.f27675d.mo28025c(zzcze);
        this.f27683c.mo28811a(new C9840ym(this, zzcze), zzbbm.f25065b);
        zzbar.m26383a((zzbbh<V>) zzcze, (zzban<? super V>) new C9861zm<Object>(this, zzcze), zzbbm.f25065b);
        return zzcze;
    }

    /* renamed from: a */
    public final zzczl<O> mo31332a(E e) {
        return this.f27686f.mo31319a(e, (zzbbh<I>) mo31325a());
    }

    /* synthetic */ zzczl(zzczf zzczf, Object obj, String str, zzbbh zzbbh, List list, zzbbh zzbbh2, C9714sm smVar) {
        this(zzczf, obj, null, zzbbh, list, zzbbh2);
    }
}
