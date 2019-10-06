package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcew implements zzdti<Set<zzbuz<zzczz>>> {

    /* renamed from: a */
    private final zzdtu<String> f26499a;

    /* renamed from: b */
    private final zzdtu<Context> f26500b;

    /* renamed from: c */
    private final zzdtu<Executor> f26501c;

    /* renamed from: d */
    private final zzdtu<Map<zzczs, zzcez>> f26502d;

    public zzcew(zzdtu<String> zzdtu, zzdtu<Context> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<Map<zzczs, zzcez>> zzdtu4) {
        this.f26499a = zzdtu;
        this.f26500b = zzdtu2;
        this.f26501c = zzdtu3;
        this.f26502d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        Set set;
        String str = (String) this.f26499a.get();
        Context context = (Context) this.f26500b.get();
        Executor executor = (Executor) this.f26501c.get();
        Map map = (Map) this.f26502d.get();
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23990Pd)).booleanValue()) {
            zzwj zzwj = new zzwj(new zzwo(context));
            zzwj.mo32329a((zzwk) new C8748Ai(str));
            set = Collections.singleton(new zzbuz(new zzcex(zzwj, map), executor));
        } else {
            set = Collections.emptySet();
        }
        zzdto.m30114a(set, "Cannot return null from a non-@Nullable @Provides method");
        return set;
    }
}
