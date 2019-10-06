package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzblq implements zzbal<zzcxu, zzcxu> {

    /* renamed from: a */
    private Map<String, zzbls> f25506a;

    public zzblq(Map<String, zzbls> map) {
        this.f25506a = map;
    }

    /* renamed from: a */
    public final /* synthetic */ zzbbh mo26658a(Object obj) throws Exception {
        zzcxu zzcxu = (zzcxu) obj;
        for (zzcxt zzcxt : zzcxu.f27596b.f27592c) {
            if (this.f25506a.containsKey(zzcxt.f27593a)) {
                ((zzbls) this.f25506a.get(zzcxt.f27593a)).mo30727a(zzcxt.f27594b);
            }
        }
        return zzbar.m26376a(zzcxu);
    }
}
