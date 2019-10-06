package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

public final class zzbyj implements zzdti<zzty> {

    /* renamed from: a */
    private final zzdtu<zzbai> f26076a;

    /* renamed from: b */
    private final zzdtu<String> f26077b;

    public zzbyj(zzdtu<zzbai> zzdtu, zzdtu<String> zzdtu2) {
        this.f26076a = zzdtu;
        this.f26077b = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzbai zzbai = (zzbai) this.f26076a.get();
        String str = (String) this.f26077b.get();
        zzk.zzlg();
        zzty zzty = new zzty(zzaxi.m26104a(), zzbai, str, new JSONObject(), false, true);
        zzdto.m30114a(zzty, "Cannot return null from a non-@Nullable @Provides method");
        return zzty;
    }
}
