package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@zzard
public final class zzasd {

    /* renamed from: a */
    private final List<String> f24725a;

    /* renamed from: b */
    private final String f24726b;

    /* renamed from: c */
    private final String f24727c;

    /* renamed from: d */
    private final String f24728d;

    /* renamed from: e */
    private final boolean f24729e;

    /* renamed from: f */
    private final String f24730f;

    /* renamed from: g */
    private final String f24731g;

    /* renamed from: h */
    private String f24732h;

    /* renamed from: i */
    private final int f24733i;

    /* renamed from: j */
    private final boolean f24734j;

    /* renamed from: k */
    private final JSONObject f24735k;

    /* renamed from: l */
    private final String f24736l;

    /* renamed from: m */
    private final boolean f24737m;

    public zzasd(JSONObject jSONObject) {
        this.f24732h = jSONObject.optString("url");
        this.f24726b = jSONObject.optString("base_uri");
        this.f24727c = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        int i = 1;
        this.f24729e = optString != null && (optString.equals("1") || optString.equals("true"));
        this.f24730f = jSONObject.optString("request_id");
        this.f24728d = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        this.f24725a = optString2 == null ? null : Arrays.asList(optString2.split(","));
        if (jSONObject.optInt("valid", 0) == 1) {
            i = -2;
        }
        this.f24733i = i;
        this.f24731g = jSONObject.optString("fetched_ad");
        this.f24734j = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        this.f24735k = optJSONObject;
        this.f24736l = jSONObject.optString("analytics_query_ad_event_id");
        this.f24737m = jSONObject.optBoolean("is_analytics_logging_enabled");
    }

    /* renamed from: b */
    public final String mo30040b() {
        return this.f24726b;
    }

    /* renamed from: c */
    public final String mo30041c() {
        return this.f24727c;
    }

    /* renamed from: a */
    public final String mo30039a() {
        return this.f24732h;
    }

    /* renamed from: d */
    public final boolean mo30042d() {
        return this.f24729e;
    }

    /* renamed from: e */
    public final JSONObject mo30043e() {
        return this.f24735k;
    }
}
