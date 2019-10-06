package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

@zzard
public final class zzaso implements zzasb {

    /* renamed from: a */
    private zzalj<JSONObject, JSONObject> f24801a;

    /* renamed from: b */
    private zzalj<JSONObject, JSONObject> f24802b;

    public zzaso(Context context) {
        zzalr a = zzk.zzlt().mo29806a(context, zzbai.m26367a());
        zzaln<JSONObject> zzaln = zzalo.f24411b;
        this.f24801a = a.mo29808a("google.afma.request.getAdDictionary", zzaln, zzaln);
        zzalr a2 = zzk.zzlt().mo29806a(context, zzbai.m26367a());
        zzaln<JSONObject> zzaln2 = zzalo.f24411b;
        this.f24802b = a2.mo29808a("google.afma.sdkConstants.getSdkConstants", zzaln2, zzaln2);
    }

    /* renamed from: a */
    public final zzalj<JSONObject, JSONObject> mo30037a() {
        return this.f24802b;
    }
}
