package com.google.android.gms.internal.ads;

@zzard
public final class zzaly {

    /* renamed from: a */
    private zzakh f24420a;

    /* renamed from: b */
    private zzbbr<zzalf> f24421b;

    zzaly(zzakh zzakh) {
        this.f24420a = zzakh;
    }

    /* renamed from: a */
    private final void m25210a() {
        if (this.f24421b == null) {
            this.f24421b = new zzbbr<>();
            zzbbr<zzalf> zzbbr = this.f24421b;
            this.f24420a.mo29797b((zzdh) null).mo30344a(new C8950Ka(zzbbr), new C8992Ma(zzbbr));
        }
    }

    /* renamed from: a */
    public final zzamd mo29810a(String str, zzalm zzalm, zzall zzall) {
        m25210a();
        return new zzamd(this.f24421b, str, zzalm, zzall);
    }

    /* renamed from: a */
    public final void mo29811a(String str, zzaho<? super zzalf> zzaho) {
        m25210a();
        this.f24421b = (zzbbr) zzbar.m26379a((zzbbh<A>) this.f24421b, (zzbal<? super A, ? extends B>) new C9013Na<Object,Object>(str, zzaho), zzbbm.f25065b);
    }

    /* renamed from: b */
    public final void mo29812b(String str, zzaho<? super zzalf> zzaho) {
        this.f24421b = (zzbbr) zzbar.m26380a((zzbbh<A>) this.f24421b, (zzbam<A, B>) new C9034Oa<A,B>(str, zzaho), zzbbm.f25065b);
    }
}
