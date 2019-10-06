package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.Mb */
public final class C11747Mb extends C11735Ib {

    /* renamed from: q */
    public String f36754q;

    /* renamed from: r */
    public String f36755r;

    /* renamed from: s */
    public long f36756s;

    /* renamed from: t */
    public boolean f36757t;

    public C11747Mb(String str, C11707Ba ba, C11706B b, String str2) {
        super(C11740Ka.PreAuthRequest, ba, b, C11735Ib.m38862b(str, str2));
    }

    /* renamed from: b */
    public final String mo38503b() {
        HashMap hashMap = new HashMap();
        hashMap.put("response_type", "token");
        hashMap.put("grant_type", "client_credentials");
        hashMap.put("return_authn_schemes", "true");
        hashMap.put("device_info", C11723Fa.m38812a(C11844lb.m39198a().toString()));
        hashMap.put("app_info", C11723Fa.m38812a(C11828hb.m39167a().toString()));
        hashMap.put("risk_data", C11723Fa.m38812a(C12010u.m39718a().mo39195c().toString()));
        return C11723Fa.m38813a((Map) hashMap);
    }

    /* renamed from: c */
    public final void mo38505c() {
        JSONObject m = mo38515m();
        try {
            this.f36754q = m.getString("access_token");
            this.f36755r = m.getString("scope");
            this.f36756s = m.getLong("expires_in");
            JSONArray jSONArray = m.getJSONArray("supported_authn_schemes");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.get(i).equals("phone_pin")) {
                    this.f36757t = true;
                }
            }
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
        return "{\"scope\":\"https://api.paypal.com/v1/payments/.* https://api.paypal.com/v1/vault/credit-card https://api.paypal.com/v1/vault/credit-card/.* openid\",\"access_token\":\"iPVzWUwTo1fEG6n.2sTZCahv8wa2b8uGpBs1KZ-6XxA\",\"token_type\":\"Bearer\",\"expires_in\":900,\"supported_authn_schemes\": [ \"email_password\", \"phone_pin\" ]}";
    }
}
