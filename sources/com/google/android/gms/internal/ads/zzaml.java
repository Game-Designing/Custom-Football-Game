package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzaml {

    /* renamed from: a */
    private final String f24428a;

    /* renamed from: b */
    private final String f24429b;

    /* renamed from: c */
    public final List<String> f24430c;

    /* renamed from: d */
    private final String f24431d;

    /* renamed from: e */
    private final String f24432e;

    /* renamed from: f */
    private final List<String> f24433f;

    /* renamed from: g */
    private final List<String> f24434g;

    /* renamed from: h */
    private final List<String> f24435h;

    /* renamed from: i */
    private final List<String> f24436i;

    /* renamed from: j */
    private final List<String> f24437j;

    /* renamed from: k */
    public final String f24438k;

    /* renamed from: l */
    private final List<String> f24439l;

    /* renamed from: m */
    private final List<String> f24440m;

    /* renamed from: n */
    private final List<String> f24441n;

    /* renamed from: o */
    private final String f24442o;

    /* renamed from: p */
    private final String f24443p;

    /* renamed from: q */
    private final String f24444q;

    /* renamed from: r */
    private final String f24445r;

    /* renamed from: s */
    private final String f24446s;

    /* renamed from: t */
    private final List<String> f24447t;

    /* renamed from: u */
    private final String f24448u;

    /* renamed from: v */
    public final String f24449v;

    /* renamed from: w */
    private final long f24450w;

    public zzaml(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.f24429b = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f24430c = Collections.unmodifiableList(arrayList);
        this.f24431d = jSONObject.optString("allocation_id", null);
        zzk.zzly();
        this.f24433f = zzamn.m25239a(jSONObject, "clickurl");
        zzk.zzly();
        this.f24434g = zzamn.m25239a(jSONObject, "imp_urls");
        zzk.zzly();
        this.f24435h = zzamn.m25239a(jSONObject, "downloaded_imp_urls");
        zzk.zzly();
        this.f24437j = zzamn.m25239a(jSONObject, "fill_urls");
        zzk.zzly();
        this.f24439l = zzamn.m25239a(jSONObject, "video_start_urls");
        zzk.zzly();
        this.f24441n = zzamn.m25239a(jSONObject, "video_complete_urls");
        zzk.zzly();
        this.f24440m = zzamn.m25239a(jSONObject, "video_reward_urls");
        this.f24442o = jSONObject.optString("transaction_id");
        this.f24443p = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzk.zzly();
            list = zzamn.m25239a(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.f24436i = list;
        this.f24428a = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.f24438k = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.f24432e = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.f24444q = jSONObject.optString("html_template", null);
        this.f24445r = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.f24446s = optJSONObject3 != null ? optJSONObject3.toString() : null;
        zzk.zzly();
        this.f24447t = zzamn.m25239a(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.f24448u = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.f24449v = jSONObject.optString("response_type", null);
        this.f24450w = jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
