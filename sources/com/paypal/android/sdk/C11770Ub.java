package com.paypal.android.sdk;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.Ub */
public final class C11770Ub implements C11837jc {

    /* renamed from: a */
    private String f37039a = C11756Pb.m38949a(C11761Rb.PREFERRED_PAYMENT_METHOD);

    /* renamed from: b */
    private C11782Yb f37040b;

    private C11770Ub(JSONObject jSONObject) {
        this.f37040b = new C11782Yb(jSONObject.optJSONArray("funding_sources"), jSONObject.optJSONObject("backup_funding_instrument"));
    }

    /* renamed from: a */
    public static ArrayList m38980a(JSONObject jSONObject, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            C11770Ub ub = new C11770Ub(jSONObject);
            if (ub.m38981h()) {
                arrayList.add(ub);
            }
        }
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    C11770Ub ub2 = new C11770Ub(jSONArray.getJSONObject(i));
                    if (ub2.m38981h()) {
                        arrayList.add(ub2);
                    }
                } catch (JSONException e) {
                }
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    private boolean m38981h() {
        return this.f37040b.mo38663e() > 0;
    }

    /* renamed from: a */
    public final String mo38634a() {
        return this.f37040b.mo38662d();
    }

    /* renamed from: b */
    public final String mo38635b() {
        return this.f37039a;
    }

    /* renamed from: c */
    public final String mo38636c() {
        return this.f37040b.mo38659a();
    }

    /* renamed from: d */
    public final String mo38637d() {
        return this.f37040b.mo38661c();
    }

    /* renamed from: e */
    public final boolean mo38638e() {
        return this.f37040b.mo38660b();
    }

    /* renamed from: f */
    public final C11782Yb mo38639f() {
        return this.f37040b;
    }

    /* renamed from: g */
    public final boolean mo38640g() {
        return this.f37040b.mo38663e() == 1;
    }
}
