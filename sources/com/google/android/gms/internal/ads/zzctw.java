package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Set;
import java.util.concurrent.Callable;

public final class zzctw implements zzcva<zzctv> {

    /* renamed from: a */
    private final zzbbl f27375a;

    /* renamed from: b */
    private final Context f27376b;

    /* renamed from: c */
    private final Set<String> f27377c;

    public zzctw(zzbbl zzbbl, Context context, Set<String> set) {
        this.f27375a = zzbbl;
        this.f27376b = context;
        this.f27377c = set;
    }

    /* renamed from: a */
    public final zzbbh<zzctv> mo28586a() {
        return this.f27375a.mo30326a((Callable<T>) new C8835El<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzctv mo31261b() throws Exception {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24044Yd)).booleanValue() || !zzctv.m28869b(this.f27377c)) {
            return new zzctv(null);
        }
        return new zzctv(zzk.zzlv().mo29997a(this.f27376b));
    }
}
