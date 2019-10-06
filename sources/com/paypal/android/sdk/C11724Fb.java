package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

/* renamed from: com.paypal.android.sdk.Fb */
public class C11724Fb extends C12031za {

    /* renamed from: m */
    private static final String f36663m = C11724Fb.class.getSimpleName();

    /* renamed from: n */
    private Map f36664n;

    /* renamed from: o */
    private String f36665o;

    /* renamed from: p */
    private String f36666p;

    /* renamed from: q */
    private String f36667q;

    public C11724Fb(C11707Ba ba, C11706B b, String str, String str2, String str3) {
        C11731Ha ha = new C11731Ha(C11740Ka.GetAppInfoRequest);
        StringBuilder sb = new StringBuilder("Bearer ");
        if (C11757Q.m38953a(str) && str2 == null) {
            str2 = "mock_euat";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder("/");
        sb3.append(str3);
        super(ha, ba, b, sb2, sb3.toString());
        this.f36664n = new HashMap();
        mo38500a("Content-Type", "application/x-www-form-urlencoded");
    }

    /* renamed from: a */
    private static void m38827a(JSONArray jSONArray, Map map) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name");
                    String optString2 = jSONObject.optString(DonationsAnalytics.VALUE);
                    if (C11723Fa.m38822b((CharSequence) optString) && C11723Fa.m38822b((CharSequence) optString2)) {
                        map.put(optString, optString2);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final String mo38503b() {
        return "";
    }

    /* renamed from: c */
    public final void mo38505c() {
        JSONObject jSONObject;
        JSONObject m = mo38515m();
        JSONArray optJSONArray = m.optJSONArray("capabilities");
        String str = "attributes";
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                if (i >= optJSONArray.length()) {
                    jSONObject = null;
                    break;
                }
                jSONObject = optJSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    if ("PAYPAL_ACCESS".equals(jSONObject.optString("name"))) {
                        break;
                    }
                }
                i++;
            }
            if (jSONObject != null) {
                m38827a(jSONObject.optJSONArray(str), this.f36664n);
                new StringBuilder("Attributes: ").append(this.f36664n.toString());
            }
        }
        JSONArray optJSONArray2 = m.optJSONArray(str);
        if (optJSONArray2 != null) {
            HashMap hashMap = new HashMap();
            m38827a(optJSONArray2, hashMap);
            this.f36665o = (String) hashMap.get("privacy_policy_url");
            this.f36666p = (String) hashMap.get("user_agreement_url");
            this.f36667q = (String) hashMap.get("display_name");
        }
    }

    /* renamed from: d */
    public final void mo38507d() {
    }

    /* renamed from: e */
    public final String mo38508e() {
        return " {\n     \"attributes\": [\n         {\n             \"name\": \"display_name\",\n             \"value\": \"Example Merchant\"\n         },\n         {\n             \"name\": \"privacy_policy_url\",\n             \"value\": \"http://www.example.com/privacy-policy\"\n         },\n         {\n             \"name\": \"user_agreement_url\",\n             \"value\": \"http://www.example.com/user-agreement\"\n         }\n     ],\n     \"name\": \"LiveTestApp\",\n     \"capabilities\": [\n         {\n             \"scopes\": [],\n             \"name\": \"PAYPAL_ACCESS\",\n             \"attributes\": [\n                 {\n                     \"name\": \"openid_connect\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_date_of_birth\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_fullname\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_gender\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_zip\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_language\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_city\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_country\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_timezone\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_email\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_street_address1\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_street_address2\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_phone_number\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_locale\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_state\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_age_range\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_verified\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_creation_date\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_type\",\n                     \"value\": \"Y\"\n                 }\n             ]\n         },\n         {\n             \"scopes\": [\n                 \"https://api.paypal.com/v1/payments/.*\",\n                 \"https://api.paypal.com/v1/vault/credit-card\",\n                 \"https://api.paypal.com/v1/vault/credit-card/.*\"\n             ],\n             \"name\": \"PAYMENT\",\n             \"features\": [\n                 {\n                     \"status\": \"ACTIVE\",\n                     \"name\": \"ACCEPT_CARD\"\n                 },\n                 {\n                     \"status\": \"ACTIVE\",\n                     \"name\": \"ACCEPT_PAYPAL\"\n                 }\n             ]\n         }\n     ]\n }    ";
    }

    /* renamed from: t */
    public final Map mo38565t() {
        return this.f36664n;
    }

    /* renamed from: u */
    public final String mo38566u() {
        return this.f36665o;
    }

    /* renamed from: v */
    public final String mo38567v() {
        return this.f36666p;
    }

    /* renamed from: w */
    public final String mo38568w() {
        return this.f36667q;
    }
}
