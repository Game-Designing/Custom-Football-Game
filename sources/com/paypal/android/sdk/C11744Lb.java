package com.paypal.android.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.Lb */
public abstract class C11744Lb extends C12032zb {
    public C11744Lb(C11740Ka ka, C11707Ba ba, C11706B b, String str) {
        super(ka, ba, b, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo38594a(JSONObject jSONObject) {
        String str;
        String str2 = "";
        String string = jSONObject.getString("name");
        String string2 = jSONObject.getString("message");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray("details").getJSONObject(0);
            str = jSONObject2.getString("field");
            try {
                str2 = jSONObject2.getString("issue");
                if (string.equals("VALIDATION_ERROR") && str.contains("amount.currency")) {
                    string = "pp_service_error_bad_currency";
                }
            } catch (JSONException e) {
            }
        } catch (JSONException e2) {
            str = str2;
        }
        StringBuilder sb = new StringBuilder("field:");
        sb.append(str);
        sb.append(", issue:");
        sb.append(str2);
        mo38501a(string, string2, sb.toString());
    }
}
