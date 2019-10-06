package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.Gb */
public final class C11728Gb extends C11735Ib {

    /* renamed from: q */
    private final String f36679q;

    /* renamed from: r */
    private final String f36680r;

    public C11728Gb(C11707Ba ba, C11706B b, String str, String str2, String str3, String str4) {
        super(C11740Ka.LoginChallengeRequest, ba, b, C11735Ib.m38862b(str, str2));
        this.f36679q = str3;
        this.f36680r = str4;
    }

    /* renamed from: b */
    public final String mo38503b() {
        HashMap hashMap = new HashMap();
        hashMap.put("authn_schemes", "2fa_pre_login");
        hashMap.put("nonce", this.f36679q);
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("authn_scheme", "security_key_sms_token");
        jSONObject.accumulate("token_identifier", this.f36680r);
        hashMap.put("2fa_token_identifiers", C11735Ib.m38861a(jSONObject));
        return C11723Fa.m38813a((Map) hashMap);
    }

    /* renamed from: c */
    public final void mo38505c() {
        JSONObject m = mo38515m();
        try {
            this.f36703n = m.getString("nonce");
        } catch (JSONException e) {
            mo38574b(m);
        }
    }

    /* renamed from: d */
    public final void mo38507d() {
        mo38574b(mo38515m());
    }

    /* renamed from: e */
    public final String mo38508e() {
        return "{\"nonce\": \"mock-login-challenge-nonce\"}";
    }
}
