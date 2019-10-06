package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzamm {

    /* renamed from: a */
    public final List<zzaml> f24451a;

    /* renamed from: b */
    private final long f24452b;

    /* renamed from: c */
    private final List<String> f24453c;

    /* renamed from: d */
    private final List<String> f24454d;

    /* renamed from: e */
    private final List<String> f24455e;

    /* renamed from: f */
    private final List<String> f24456f;

    /* renamed from: g */
    private final List<String> f24457g;

    /* renamed from: h */
    private final boolean f24458h;

    /* renamed from: i */
    private final String f24459i;

    /* renamed from: j */
    private final long f24460j;

    /* renamed from: k */
    private final String f24461k;

    /* renamed from: l */
    private final int f24462l;

    /* renamed from: m */
    private final int f24463m;

    /* renamed from: n */
    private final long f24464n;

    /* renamed from: o */
    private final boolean f24465o;

    /* renamed from: p */
    private final boolean f24466p;

    /* renamed from: q */
    private final boolean f24467q;

    /* renamed from: r */
    private final boolean f24468r;

    /* renamed from: s */
    private int f24469s;

    /* renamed from: t */
    private int f24470t;

    /* renamed from: u */
    private boolean f24471u;

    public zzamm(JSONObject jSONObject) throws JSONException {
        if (zzbad.m26354a(2)) {
            String str = "Mediation Response JSON: ";
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzawz.m26003f(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzaml zzaml = new zzaml(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzaml.f24449v)) {
                    this.f24471u = true;
                }
                arrayList.add(zzaml);
                if (i < 0) {
                    Iterator it = zzaml.f24430c.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((String) it.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException e) {
            }
        }
        this.f24469s = i;
        this.f24470t = jSONArray.length();
        this.f24451a = Collections.unmodifiableList(arrayList);
        this.f24459i = jSONObject.optString("qdata");
        this.f24463m = jSONObject.optInt("fs_model_type", -1);
        long j = -1;
        this.f24464n = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f24452b = optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzk.zzly();
            this.f24453c = zzamn.m25239a(optJSONObject, "click_urls");
            zzk.zzly();
            this.f24454d = zzamn.m25239a(optJSONObject, "imp_urls");
            zzk.zzly();
            this.f24455e = zzamn.m25239a(optJSONObject, "downloaded_imp_urls");
            zzk.zzly();
            this.f24456f = zzamn.m25239a(optJSONObject, "nofill_urls");
            zzk.zzly();
            this.f24457g = zzamn.m25239a(optJSONObject, "remote_ping_urls");
            this.f24458h = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            if (optLong > 0) {
                j = 1000 * optLong;
            }
            this.f24460j = j;
            zzato a = zzato.m25809a(optJSONObject.optJSONArray("rewards"));
            if (a == null) {
                this.f24461k = null;
                this.f24462l = 0;
            } else {
                this.f24461k = a.f24820a;
                this.f24462l = a.f24821b;
            }
            this.f24465o = optJSONObject.optBoolean("use_displayed_impression", false);
            this.f24466p = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.f24467q = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.f24468r = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.f24452b = -1;
        this.f24453c = null;
        this.f24454d = null;
        this.f24455e = null;
        this.f24456f = null;
        this.f24457g = null;
        this.f24460j = -1;
        this.f24461k = null;
        this.f24462l = 0;
        this.f24465o = false;
        this.f24458h = false;
        this.f24466p = false;
        this.f24467q = false;
        this.f24468r = false;
    }
}
