package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzclv implements zzcjz<zzams, zzcla> {

    /* renamed from: a */
    private final zzclc f26997a;

    public zzclv(zzclc zzclc) {
        this.f26997a = zzclc;
    }

    /* renamed from: a */
    public final zzcjy<zzams, zzcla> mo31189a(String str, JSONObject jSONObject) throws Throwable {
        zzams a = this.f26997a.mo31200a(str, jSONObject);
        if (a == null) {
            return null;
        }
        return new zzcjy<>(a, new zzcla(), str);
    }
}
