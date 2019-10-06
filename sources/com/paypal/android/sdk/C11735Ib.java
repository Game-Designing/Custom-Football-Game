package com.paypal.android.sdk;

import android.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.Ib */
public abstract class C11735Ib extends C12031za {

    /* renamed from: m */
    private static final String f36702m = C11735Ib.class.getSimpleName();

    /* renamed from: n */
    public String f36703n;

    /* renamed from: o */
    public boolean f36704o;

    /* renamed from: p */
    public Map f36705p;

    public C11735Ib(C11740Ka ka, C11707Ba ba, C11706B b, String str) {
        super(new C11731Ha(ka), ba, b, str);
        mo38500a("Accept", "application/json; charset=utf-8");
        mo38500a("Accept-Language", "en_US");
        mo38500a("Content-Type", "application/x-www-form-urlencoded");
    }

    /* renamed from: a */
    protected static String m38861a(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return C11723Fa.m38812a(jSONArray.toString());
    }

    /* renamed from: b */
    protected static String m38862b(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder("Basic ");
        if (!C11757Q.m38953a(str) || str2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(new String(Base64.encode(str2.getBytes(), 2)));
            sb2.append(":");
            str3 = sb2.toString();
        } else {
            str3 = "mock:";
        }
        sb.append(str3);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo38574b(JSONObject jSONObject) {
        String string = jSONObject.getString("error");
        String optString = jSONObject.optString("error_description");
        String str = "nonce";
        if (jSONObject.has(str)) {
            this.f36703n = jSONObject.getString(str);
        }
        String str2 = "2fa_enabled";
        if (jSONObject.has(str2) && jSONObject.getBoolean(str2)) {
            this.f36704o = true;
            this.f36705p = new LinkedHashMap();
            String str3 = "2fa_token_identifier";
            if (jSONObject.has(str3)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str3);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string2 = jSONObject2.getString("type");
                    String string3 = jSONObject2.getString("token_identifier");
                    String string4 = jSONObject2.getString("token_identifier_display");
                    String str4 = ",";
                    if ("sms_otp".equals(string2)) {
                        this.f36705p.put(string3, string4);
                        StringBuilder sb = new StringBuilder("adding token [");
                        sb.append(string3);
                        sb.append(str4);
                        sb.append(string4);
                        sb.append("]");
                    } else {
                        StringBuilder sb2 = new StringBuilder("skipping token [");
                        sb2.append(string3);
                        sb2.append(str4);
                        sb2.append(string4);
                        sb2.append("], as the type is not supported:");
                        sb2.append(string2);
                    }
                }
            }
        }
        mo38501a(string, optString, null);
    }
}
