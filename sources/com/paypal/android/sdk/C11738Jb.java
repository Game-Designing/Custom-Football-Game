package com.paypal.android.sdk;

import java.math.BigDecimal;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.Jb */
public class C11738Jb {

    /* renamed from: a */
    private String f36707a;

    /* renamed from: b */
    private Integer f36708b;

    /* renamed from: c */
    private BigDecimal f36709c;

    /* renamed from: d */
    private String f36710d;

    /* renamed from: e */
    private String f36711e;

    static {
        C11738Jb.class.getSimpleName();
    }

    public C11738Jb(String str, Integer num, BigDecimal bigDecimal, String str2, String str3) {
        this.f36707a = str;
        this.f36708b = num;
        this.f36709c = bigDecimal;
        this.f36710d = str2;
        this.f36711e = str3;
    }

    /* renamed from: a */
    public static JSONArray m38869a(C11738Jb[] jbArr) {
        if (jbArr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (C11738Jb jb : jbArr) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("quantity", Integer.toString(jb.f36708b.intValue()));
            jSONObject.accumulate("name", jb.f36707a);
            jSONObject.accumulate("price", jb.f36709c.toString());
            jSONObject.accumulate("currency", jb.f36710d);
            jSONObject.accumulate("sku", jb.f36711e);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
