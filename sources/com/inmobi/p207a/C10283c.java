package com.inmobi.p207a;

import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.p222e.C10669f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;

/* renamed from: com.inmobi.a.c */
/* compiled from: CarbGetListNetworkResponse */
public class C10283c {

    /* renamed from: e */
    private static final String f31156e = C10283c.class.getSimpleName();

    /* renamed from: a */
    boolean f31157a = true;

    /* renamed from: b */
    List<C10284d> f31158b;

    /* renamed from: c */
    String f31159c;

    /* renamed from: d */
    int f31160d = 0;

    /* renamed from: f */
    private C10677d f31161f;

    public C10283c(C10677d dVar) {
        this.f31161f = dVar;
        this.f31158b = new ArrayList();
        m33533a();
        if (this.f31157a) {
            try {
                C10659b.m34983a().mo34485a(new C10669f("signals", "InvalidCarbGetResponse"));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                sb.append(e.getMessage());
                sb.append(")");
            }
        }
    }

    /* renamed from: a */
    private void m33533a() {
        String str = "Error response for Carb list received. Error code:";
        if (!this.f31161f.mo34510a()) {
            try {
                JSONObject jSONObject = new JSONObject(this.f31161f.mo34511b());
                if (jSONObject.getBoolean(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    this.f31159c = jSONObject2.getString("req_id");
                    JSONArray jSONArray = jSONObject2.getJSONArray("p_apps");
                    int i = 0;
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        String optString = jSONObject3.optString("bid", null);
                        String optString2 = jSONObject3.optString("inm_id", null);
                        if (!(optString == null || optString2 == null || optString2.trim().length() <= 0)) {
                            this.f31158b.add(new C10284d(optString, optString2));
                        }
                        i++;
                        this.f31160d = i;
                    }
                } else {
                    new StringBuilder(str).append(jSONObject.optInt("errorCode"));
                }
                this.f31157a = false;
            } catch (JSONException e) {
            }
        } else {
            new StringBuilder(str).append(this.f31161f.f32591b.f32552a);
        }
    }
}
