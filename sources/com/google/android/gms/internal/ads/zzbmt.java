package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

public final class zzbmt implements zzdti<zzty> {

    /* renamed from: a */
    private final zzdtu<zzcxm> f25575a;

    /* renamed from: b */
    private final zzdtu<zzbai> f25576b;

    /* renamed from: c */
    private final zzdtu<JSONObject> f25577c;

    /* renamed from: d */
    private final zzdtu<String> f25578d;

    private zzbmt(zzdtu<zzcxm> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<JSONObject> zzdtu3, zzdtu<String> zzdtu4) {
        this.f25575a = zzdtu;
        this.f25576b = zzdtu2;
        this.f25577c = zzdtu3;
        this.f25578d = zzdtu4;
    }

    /* renamed from: a */
    public static zzbmt m27268a(zzdtu<zzcxm> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<JSONObject> zzdtu3, zzdtu<String> zzdtu4) {
        return new zzbmt(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        this.f25575a.get();
        zzbai zzbai = (zzbai) this.f25576b.get();
        JSONObject jSONObject = (JSONObject) this.f25577c.get();
        String str = (String) this.f25578d.get();
        boolean equals = "native".equals(str);
        zzk.zzlg();
        zzty zzty = new zzty(zzaxi.m26104a(), zzbai, str, jSONObject, false, equals);
        zzdto.m30114a(zzty, "Cannot return null from a non-@Nullable @Provides method");
        return zzty;
    }
}
