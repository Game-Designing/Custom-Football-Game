package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzbyy extends zzbyx {

    /* renamed from: b */
    private final JSONObject f26143b;

    /* renamed from: c */
    private final boolean f26144c;

    /* renamed from: d */
    private final boolean f26145d;

    /* renamed from: e */
    private final boolean f26146e;

    public zzbyy(zzcxm zzcxm, JSONObject jSONObject) {
        super(zzcxm);
        this.f26143b = zzazc.m26266a(jSONObject, "tracking_urls_and_actions", "active_view");
        this.f26144c = zzazc.m26270a(false, jSONObject, "allow_pub_owned_ad_view");
        this.f26145d = zzazc.m26270a(false, jSONObject, "attribution", "allow_pub_rendering");
        this.f26146e = zzazc.m26270a(false, jSONObject, "enable_omid");
    }

    /* renamed from: a */
    public final JSONObject mo31029a() {
        JSONObject jSONObject = this.f26143b;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.f26142a.f27572w);
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: b */
    public final boolean mo31030b() {
        return this.f26144c;
    }

    /* renamed from: d */
    public final boolean mo31032d() {
        return this.f26146e;
    }

    /* renamed from: c */
    public final boolean mo31031c() {
        return this.f26145d;
    }
}
