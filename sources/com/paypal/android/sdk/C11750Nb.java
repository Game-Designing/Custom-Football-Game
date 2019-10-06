package com.paypal.android.sdk;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.Nb */
public final class C11750Nb extends C11744Lb {

    /* renamed from: m */
    public final String f36763m;

    /* renamed from: n */
    private final String f36764n;

    /* renamed from: o */
    private final String f36765o;

    /* renamed from: p */
    private final String f36766p;

    /* renamed from: q */
    private final int f36767q;

    /* renamed from: r */
    private final int f36768r;

    /* renamed from: s */
    private String f36769s;

    /* renamed from: t */
    private String f36770t;

    /* renamed from: u */
    private Date f36771u;

    public C11750Nb(C11707Ba ba, C11706B b, String str, String str2, String str3, String str4, String str5, int i, int i2) {
        super(C11740Ka.TokenizeCreditCardRequest, ba, b, str);
        this.f36763m = str2;
        this.f36764n = str3;
        if (str4 != null) {
            this.f36765o = str4;
            this.f36766p = str5;
            this.f36767q = i;
            this.f36768r = i2;
            return;
        }
        throw new RuntimeException("cardNumber should not be null.  If it is, then you're probably trying to tokenize a card that's already been tokenized.");
    }

    /* renamed from: b */
    public final String mo38503b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("payer_id", this.f36763m);
        jSONObject.accumulate("cvv2", this.f36766p);
        jSONObject.accumulate("expire_month", Integer.valueOf(this.f36767q));
        jSONObject.accumulate("expire_year", Integer.valueOf(this.f36768r));
        jSONObject.accumulate("number", this.f36765o);
        jSONObject.accumulate("type", this.f36764n);
        return jSONObject.toString();
    }

    /* renamed from: c */
    public final void mo38505c() {
        JSONObject m = mo38515m();
        try {
            this.f36769s = m.getString("id");
            String string = m.getString("number");
            if (this.f36770t == null || !this.f36770t.endsWith(string.substring(string.length() - 4))) {
                this.f36770t = string;
            }
            this.f36771u = C12004sb.m39705a(m.getString("valid_until"));
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
        StringBuilder sb = new StringBuilder("{\"id\":\"CARD-50Y58962PH1899901KFFBSDA\",\"valid_until\":\"2016-03-19T00:00:00.000Z\",\"state\":\"ok\",\"type\":\"visa\",\"number\":\"xxxxxxxxxxxx");
        String str = this.f36765o;
        sb.append(str.substring(str.length() - 4));
        sb.append("\",\"expire_month\":\"");
        sb.append(this.f36767q);
        sb.append("\",\"expire_year\":\"");
        sb.append(this.f36768r);
        sb.append("\",\"links\":[{\"href\":\"https://api.sandbox.paypal.com/v1/vault/credit-card/CARD-50Y58962PH1899901KFFBSDA\",\"rel\":\"self\",\"method\":\"GET\"}]}");
        return sb.toString();
    }

    /* renamed from: t */
    public final String mo38603t() {
        return this.f36769s;
    }

    /* renamed from: u */
    public final String mo38604u() {
        return this.f36770t;
    }

    /* renamed from: v */
    public final Date mo38605v() {
        return this.f36771u;
    }

    /* renamed from: w */
    public final String mo38606w() {
        return this.f36764n;
    }

    /* renamed from: x */
    public final int mo38607x() {
        return this.f36767q;
    }

    /* renamed from: y */
    public final int mo38608y() {
        return this.f36768r;
    }
}
