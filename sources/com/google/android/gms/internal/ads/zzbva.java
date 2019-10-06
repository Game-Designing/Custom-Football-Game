package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzbva extends zzbts<zzue> implements zzue {

    /* renamed from: b */
    private Map<View, zzua> f25902b = new WeakHashMap(1);

    /* renamed from: c */
    private final Context f25903c;

    /* renamed from: d */
    private final zzcxm f25904d;

    public zzbva(Context context, Set<zzbuz<zzue>> set, zzcxm zzcxm) {
        super(set);
        this.f25903c = context;
        this.f25904d = zzcxm;
    }

    /* renamed from: a */
    public final synchronized void mo28694a(zzud zzud) {
        mo30895a((zzbtu<ListenerT>) new C9190Vg<ListenerT>(zzud));
    }

    /* renamed from: a */
    public final synchronized void mo30923a(View view) {
        zzua zzua = (zzua) this.f25902b.get(view);
        if (zzua == null) {
            zzua = new zzua(this.f25903c, view);
            zzua.mo32250a((zzue) this);
            this.f25902b.put(view, zzua);
        }
        if (this.f25904d != null && this.f25904d.f27548N) {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23994Qb)).booleanValue()) {
                zzua.mo32249a(((Long) zzyt.m31536e().mo29599a(zzacu.f23988Pb)).longValue());
                return;
            }
        }
        zzua.mo32248a();
    }

    /* renamed from: b */
    public final synchronized void mo30924b(View view) {
        if (this.f25902b.containsKey(view)) {
            ((zzua) this.f25902b.get(view)).mo32251b((zzue) this);
            this.f25902b.remove(view);
        }
    }
}
