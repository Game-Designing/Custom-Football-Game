package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.mopub.common.AdType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment.BundleCons;

@zzard
public final class zzawl {

    /* renamed from: a */
    private final long f24889a;

    /* renamed from: b */
    private final List<String> f24890b = new ArrayList();

    /* renamed from: c */
    private final List<String> f24891c = new ArrayList();

    /* renamed from: d */
    private final Map<String, zzamm> f24892d = new HashMap();

    /* renamed from: e */
    private String f24893e;

    /* renamed from: f */
    private String f24894f;

    /* renamed from: g */
    private JSONObject f24895g;

    /* renamed from: h */
    private boolean f24896h;

    public zzawl(String str, long j) {
        this.f24896h = false;
        this.f24894f = str;
        this.f24889a = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f24895g = new JSONObject(str);
                if (this.f24895g.optInt("status", -1) != 1) {
                    this.f24896h = false;
                    zzbad.m26359d("App settings could not be fetched successfully.");
                    return;
                }
                this.f24896h = true;
                this.f24893e = this.f24895g.optString(BundleCons.APP_ID);
                JSONArray optJSONArray = this.f24895g.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        String optString = jSONObject.optString("format");
                        String optString2 = jSONObject.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if (AdType.INTERSTITIAL.equalsIgnoreCase(optString)) {
                                    this.f24891c.add(optString2);
                                } else if ("rewarded".equalsIgnoreCase(optString)) {
                                    JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                                    if (optJSONObject != null) {
                                        this.f24892d.put(optString2, new zzamm(optJSONObject));
                                    }
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = this.f24895g.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.f24890b.add(optJSONArray2.optString(i2));
                    }
                }
            } catch (JSONException e) {
                zzbad.m26358c("Exception occurred while processing app setting json", e);
                zzk.zzlk().mo30168a((Throwable) e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    /* renamed from: a */
    public final long mo30159a() {
        return this.f24889a;
    }

    /* renamed from: b */
    public final boolean mo30160b() {
        return this.f24896h;
    }

    /* renamed from: c */
    public final String mo30161c() {
        return this.f24894f;
    }

    /* renamed from: d */
    public final String mo30162d() {
        return this.f24893e;
    }

    /* renamed from: e */
    public final Map<String, zzamm> mo30163e() {
        return this.f24892d;
    }

    /* renamed from: f */
    public final JSONObject mo30164f() {
        return this.f24895g;
    }
}
