package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final class zzcaq {

    /* renamed from: a */
    private final zzbbl f26279a;

    /* renamed from: b */
    private final zzcau f26280b;

    /* renamed from: c */
    private final zzcbd f26281c;

    public zzcaq(zzbbl zzbbl, zzcau zzcau, zzcbd zzcbd) {
        this.f26279a = zzbbl;
        this.f26280b = zzcau;
        this.f26281c = zzcbd;
    }

    /* renamed from: a */
    public final zzbbh<zzbyt> mo31088a(zzcxu zzcxu, zzcxm zzcxm, JSONObject jSONObject) {
        zzbbh zzbbh;
        JSONObject jSONObject2 = jSONObject;
        zzcxu zzcxu2 = zzcxu;
        zzbbh a = this.f26279a.mo30326a((Callable<T>) new C8852Fh<T>(this, zzcxu, zzcxm, jSONObject2));
        zzbbh b = this.f26280b.mo31092b(jSONObject2, "images");
        zzbbh a2 = this.f26280b.mo31091a(jSONObject2, "secondary_image");
        zzbbh a3 = this.f26280b.mo31091a(jSONObject2, "app_icon");
        zzbbh c = this.f26280b.mo31094c(jSONObject2, "attribution");
        zzbbh c2 = this.f26280b.mo31093c(jSONObject2);
        zzcau zzcau = this.f26280b;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzbbh = zzbar.m26376a(null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzbbh = zzbar.m26376a(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzbbh = zzbar.m26376a(null);
                } else {
                    zzbbh = zzbar.m26379a((zzbbh<A>) zzbar.m26376a(null), (zzbal<? super A, ? extends B>) new C8957Kh<Object,Object>(zzcau, optString), zzbbm.f25064a);
                }
            }
        }
        zzbbh a4 = this.f26281c.mo31095a(jSONObject2, "custom_assets");
        zzbbc a5 = zzbar.m26377a((zzbbh<? extends V>[]) new zzbbh[]{a, b, a2, a3, c, c2, zzbbh, a4});
        C8873Gh gh = new C8873Gh(this, a, b, a3, a2, c, jSONObject, c2, zzbbh, a4);
        return a5.mo30334a(gh, this.f26279a);
    }
}
