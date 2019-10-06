package com.paypal.android.sdk;

import com.mopub.common.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.yb */
public final class C12028yb extends C11744Lb {

    /* renamed from: m */
    private final String f37844m;

    /* renamed from: n */
    private final String f37845n;

    /* renamed from: o */
    private final boolean f37846o;

    /* renamed from: p */
    private final JSONObject f37847p;

    /* renamed from: q */
    private final JSONObject f37848q;

    /* renamed from: r */
    private JSONObject f37849r;

    /* renamed from: s */
    private String f37850s;

    /* renamed from: t */
    private String f37851t;

    /* renamed from: u */
    private String f37852u;

    /* renamed from: v */
    private String f37853v;

    public C12028yb(C11707Ba ba, C11706B b, String str, String str2, boolean z, String str3, String str4, String str5, String str6, JSONObject jSONObject, JSONObject jSONObject2) {
        super(C11740Ka.ApproveAndExecuteSfoPaymentRequest, ba, b, str);
        this.f37846o = z;
        this.f37844m = str5;
        this.f37845n = str6;
        this.f37847p = jSONObject;
        this.f37848q = jSONObject2;
        mo38500a("PayPal-Request-Id", str2);
        if (C11723Fa.m38822b((CharSequence) str3)) {
            mo38500a("PayPal-Partner-Attribution-Id", str3);
        }
        if (C11723Fa.m38822b((CharSequence) str4)) {
            mo38500a("PayPal-Client-Metadata-Id", str4);
        }
    }

    /* renamed from: a */
    private static String m39777a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject == null) {
                return null;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("related_resources");
            if (jSONArray2 == null) {
                return null;
            }
            JSONObject jSONObject2 = jSONArray2.getJSONObject(0);
            if (jSONObject2 == null) {
                return null;
            }
            JSONObject optJSONObject = jSONObject2.optJSONObject("authorization");
            String str = "id";
            if (optJSONObject != null) {
                return optJSONObject.optString(str);
            }
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("order");
            if (optJSONObject2 != null) {
                return optJSONObject2.optString(str);
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: b */
    public final String mo38503b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("payment_id", this.f37844m);
        jSONObject.accumulate("session_id", this.f37845n);
        JSONObject jSONObject2 = this.f37848q;
        if (jSONObject2 != null) {
            jSONObject.accumulate("funding_option", jSONObject2);
        }
        JSONObject jSONObject3 = this.f37847p;
        if (jSONObject3 != null) {
            jSONObject.accumulate("shipping_address", jSONObject3);
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.accumulate("device_info", C11723Fa.m38812a(C11844lb.m39198a().toString()));
        jSONObject4.accumulate("app_info", C11723Fa.m38812a(C11828hb.m39167a().toString()));
        jSONObject4.accumulate("risk_data", C11723Fa.m38812a(C12010u.m39718a().mo39195c().toString()));
        jSONObject.accumulate("client_info", jSONObject4);
        return jSONObject.toString();
    }

    /* renamed from: c */
    public final void mo38505c() {
        try {
            this.f37849r = mo38515m().getJSONObject("payment");
            this.f37850s = this.f37849r.optString("state");
            this.f37851t = this.f37849r.optString("create_time");
            this.f37852u = this.f37849r.optString(Constants.INTENT_SCHEME);
            this.f37853v = m39777a(this.f37849r.getJSONArray("transactions"));
        } catch (JSONException e) {
            mo38507d();
        }
    }

    /* renamed from: d */
    public final void mo38507d() {
        mo38594a(mo38515m());
    }

    /* renamed from: e */
    public final String mo38508e() {
        return "{     \"payment\": {         \"id\": \"PAY-6PU626847B294842SKPEWXHY\",         \"transactions\": [             {                 \"amount\": {                     \"total\": \"2.85\",                     \"details\": {                         \"subtotal\": \"2.85\"                     },                     \"currency\": \"USD\"                 },                 \"description\": \"Awesome Sauce\",                 \"related_resources\": [                     {                         \"sale\": {                             \"amount\": {                                 \"total\": \"2.85\",                                 \"currency\": \"USD\"                             },                             \"id\": \"5LR21373K59921925\",                             \"parent_payment\": \"PAY-6PU626847B294842SKPEWXHY\",                             \"update_time\": \"2014-07-18T18:47:06Z\",                             \"state\": \"completed\",                             \"create_time\": \"2014-07-18T18:46:55Z\",                             \"links\": [                                 {                                     \"method\": \"GET\",                                     \"rel\": \"self\",                                     \"href\": \"https://www.stage2std019.stage.\"                                 },                                 {                                     \"method\": \"POST\",                                     \"rel\": \"refund\",                                     \"href\": \"https://www.stage2std019.stage. \"                                 },                                 {                                     \"method\": \"GET\",                                     \"rel\": \"parent_payment\",                                     \"href\": \"https://www.stage2std019.stage.PEWXHY \"                                 }                             ]                         }                     }                 ]             }         ],         \"update_time\": \"2014-07-18T18:47:06Z\",         \"payer\": {             \"payer_info\": {                 \"shipping_address\": {                                      }             },             \"payment_method\": \"paypal\"         },         \"state\": \"approved\",         \"create_time\": \"2014-07-18T18:46:55Z\",         \"links\": [             {                 \"method\": \"GET\",                 \"rel\": \"self\",                 \"href\": \"https://www.stage2std019.stage.paypal.\"             }         ],         \"intent\": \"sale\"     } } ";
    }

    /* renamed from: l */
    public final void mo38514l() {
        C12010u.m39718a().mo39198g();
    }

    /* renamed from: t */
    public final String mo39213t() {
        return this.f37844m;
    }

    /* renamed from: u */
    public final boolean mo39214u() {
        return this.f37846o;
    }

    /* renamed from: v */
    public final String mo39215v() {
        return this.f37850s;
    }

    /* renamed from: w */
    public final String mo39216w() {
        return this.f37851t;
    }

    /* renamed from: x */
    public final String mo39217x() {
        return this.f37852u;
    }

    /* renamed from: y */
    public final String mo39218y() {
        return this.f37853v;
    }
}
