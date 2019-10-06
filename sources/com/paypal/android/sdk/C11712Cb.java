package com.paypal.android.sdk;

import com.mopub.common.AdType;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.Cb */
public final class C11712Cb extends C11741Kb {

    /* renamed from: A */
    private int f36638A;

    /* renamed from: B */
    private int f36639B;

    /* renamed from: C */
    private String f36640C;

    /* renamed from: D */
    private String f36641D;

    /* renamed from: E */
    private String f36642E;

    /* renamed from: F */
    private String f36643F;

    /* renamed from: x */
    private String f36644x;

    /* renamed from: y */
    private String f36645y;

    /* renamed from: z */
    private String f36646z;

    public C11712Cb(C11707Ba ba, C11706B b, String str, String str2, String str3, String str4, C11815eq eqVar, Map map, C11738Jb[] jbArr, String str5, boolean z, String str6, String str7, String str8) {
        super(C11740Ka.CreditCardPaymentRequest, ba, b, str, str2, str4, eqVar, map, jbArr, str5, z, str6, str7, str8);
        this.f36640C = str3;
    }

    public C11712Cb(C11707Ba ba, C11706B b, String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, C11815eq eqVar, Map map, C11738Jb[] jbArr, String str7, boolean z, String str8, String str9, String str10) {
        super(C11740Ka.CreditCardPaymentRequest, ba, b, str, str2, null, eqVar, map, jbArr, str7, z, str8, str9, str10);
        this.f36644x = str3;
        this.f36645y = str4;
        this.f36646z = str5;
        this.f36638A = i;
        this.f36639B = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public final JSONArray mo38544A() {
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONArray jSONArray = new JSONArray();
        if (this.f36644x != null) {
            jSONObject2 = new JSONObject();
            jSONObject2.accumulate("cvv2", this.f36646z);
            jSONObject2.accumulate("expire_month", Integer.valueOf(this.f36638A));
            jSONObject2.accumulate("expire_year", Integer.valueOf(this.f36639B));
            jSONObject2.accumulate("number", this.f36645y);
            jSONObject2.accumulate("type", this.f36644x);
            jSONObject = new JSONObject();
            str = "credit_card";
        } else {
            jSONObject2 = new JSONObject();
            jSONObject2.accumulate("payer_id", this.f36729m);
            jSONObject2.accumulate("credit_card_id", this.f36640C);
            jSONObject = new JSONObject();
            str = "credit_card_token";
        }
        jSONObject.accumulate(str, jSONObject2);
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public final String mo38545B() {
        return "credit_card";
    }

    /* renamed from: C */
    public final String mo38546C() {
        return this.f36645y;
    }

    /* renamed from: D */
    public final String mo38547D() {
        return this.f36644x;
    }

    /* renamed from: E */
    public final String mo38548E() {
        return this.f36646z;
    }

    /* renamed from: F */
    public final int mo38549F() {
        return this.f36638A;
    }

    /* renamed from: G */
    public final int mo38550G() {
        return this.f36639B;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo38551b(JSONObject jSONObject) {
        if (C11723Fa.m38822b((CharSequence) this.f36641D)) {
            jSONObject.accumulate("invoice_number", this.f36641D);
        }
        if (C11723Fa.m38822b((CharSequence) this.f36642E)) {
            jSONObject.accumulate(AdType.CUSTOM, this.f36642E);
        }
        if (C11723Fa.m38822b((CharSequence) this.f36643F)) {
            jSONObject.accumulate("soft_descriptor", this.f36643F);
        }
    }

    /* renamed from: d */
    public final C11712Cb mo38552d(String str) {
        this.f36641D = str;
        return this;
    }

    /* renamed from: e */
    public final C11712Cb mo38553e(String str) {
        this.f36642E = str;
        return this;
    }

    /* renamed from: e */
    public final String mo38508e() {
        String str;
        String a = C11836jb.m39180a(mo38584u().mo38779a().doubleValue(), mo38584u().mo38780b());
        StringBuilder sb = new StringBuilder("{\"id\":\"PAY-6RV70583SB702805EKEYSZ6Y\",\"intent\":\"sale\",\"create_time\": \"2014-02-12T22:29:49Z\",\"update_time\": \"2014-02-12T22:29:50Z\",\"payer\":{\"funding_instruments\":[{\"credit_card\":{\"expire_month\":\"");
        sb.append(this.f36638A);
        sb.append("\",\"expire_year\":\"");
        sb.append(this.f36639B);
        sb.append("\",\"number\":\"");
        if (this.f36644x != null) {
            String str2 = this.f36645y;
            str = str2.substring(str2.length() - 4);
        } else {
            str = "xxxxxxxxxx1111";
        }
        sb.append(str);
        sb.append("\",\"type\":\"VISA\"}}],\"payment_method\":\"credit_card\"},\"state\":\"approved\",\"transactions\":[{\"amount\":{\"currency\":\"USD\",\"total\":\"");
        sb.append(a);
        sb.append("\"},\"description\":\"I am a sanity check payment.\",\"item_list\":{},\"payee\":{\"merchant_id\":\"PKKPTJKL75YDS\"},\"related_resources\":[{\"sale\":{\"amount\":{\"currency\":\"USD\",\"total\":\"");
        sb.append(a);
        sb.append("\"},\"id\":\"0EW02334X44816642\",\"parent_payment\":\"PAY-123456789012345689\",\"state\":\"completed\"}}]}]}");
        return sb.toString();
    }

    /* renamed from: f */
    public final C11712Cb mo38554f(String str) {
        this.f36643F = str;
        return this;
    }
}
