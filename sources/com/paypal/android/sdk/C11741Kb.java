package com.paypal.android.sdk;

import com.mopub.common.Constants;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: com.paypal.android.sdk.Kb */
public abstract class C11741Kb extends C11744Lb {

    /* renamed from: m */
    public String f36729m;

    /* renamed from: n */
    private C11815eq f36730n;

    /* renamed from: o */
    private Map f36731o;

    /* renamed from: p */
    private C11738Jb[] f36732p;

    /* renamed from: q */
    private String f36733q;

    /* renamed from: r */
    private boolean f36734r;

    /* renamed from: s */
    private String f36735s;

    /* renamed from: t */
    private String f36736t;

    /* renamed from: u */
    private String f36737u;

    /* renamed from: v */
    private String f36738v;

    /* renamed from: w */
    private String f36739w;

    public C11741Kb(C11740Ka ka, C11707Ba ba, C11706B b, String str, String str2, String str3, C11815eq eqVar, Map map, C11738Jb[] jbArr, String str4, boolean z, String str5, String str6, String str7) {
        super(ka, ba, b, str);
        this.f36729m = str3;
        this.f36730n = eqVar;
        this.f36731o = map;
        this.f36732p = jbArr;
        this.f36733q = str4;
        this.f36734r = z;
        this.f36735s = str7;
        if (C11723Fa.m38818a((CharSequence) this.f36735s)) {
            this.f36735s = "sale";
        }
        this.f36735s = this.f36735s.toLowerCase(Locale.US);
        mo38500a("PayPal-Request-Id", str2);
        if (C11723Fa.m38822b((CharSequence) str5)) {
            mo38500a("PayPal-Partner-Attribution-Id", str5);
        }
        if (C11723Fa.m38822b((CharSequence) str6)) {
            mo38500a("PayPal-Client-Metadata-Id", str6);
        }
    }

    /* renamed from: a */
    private static String m38876a(JSONArray jSONArray) {
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
            JSONObject jSONObject3 = jSONObject2.getJSONObject("authorization");
            if (jSONObject3 == null) {
                return null;
            }
            return jSONObject3.optString("id");
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public abstract JSONArray mo38544A();

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public abstract String mo38545B();

    /* renamed from: b */
    public final String mo38503b() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.accumulate(Constants.INTENT_SCHEME, this.f36735s);
        JSONObject jSONObject3 = new JSONObject();
        JSONArray A = mo38544A();
        if (A != null) {
            jSONObject3.accumulate("funding_instruments", A);
        }
        jSONObject3.accumulate("payment_method", mo38545B());
        jSONObject2.accumulate("payer", jSONObject3);
        C11815eq eqVar = this.f36730n;
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.accumulate("currency", eqVar.mo38780b().getCurrencyCode());
        jSONObject4.accumulate("total", eqVar.mo38779a().toPlainString());
        Map map = this.f36731o;
        if (map != null && !map.isEmpty()) {
            Map map2 = this.f36731o;
            if (map2 == null || map2.isEmpty()) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                String str = "shipping";
                if (this.f36731o.containsKey(str)) {
                    jSONObject.accumulate(str, this.f36731o.get(str));
                }
                String str2 = "subtotal";
                if (this.f36731o.containsKey(str2)) {
                    jSONObject.accumulate(str2, this.f36731o.get(str2));
                }
                String str3 = "tax";
                if (this.f36731o.containsKey(str3)) {
                    jSONObject.accumulate(str3, this.f36731o.get(str3));
                }
            }
            jSONObject4.accumulate("details", jSONObject);
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.accumulate("amount", jSONObject4);
        jSONObject5.accumulate(Repo.COLUMN_DESCRIPTION, this.f36733q);
        C11738Jb[] jbArr = this.f36732p;
        if (jbArr != null && jbArr.length > 0) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.accumulate(Repo.COLUMN_ITEMS, C11738Jb.m38869a(this.f36732p));
            jSONObject5.accumulate("item_list", jSONObject6);
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject5);
        mo38551b(jSONObject5);
        jSONObject2.accumulate("transactions", jSONArray);
        return jSONObject2.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract void mo38551b(JSONObject jSONObject);

    /* renamed from: c */
    public final void mo38505c() {
        JSONObject m = mo38515m();
        try {
            this.f36736t = m.getString("state");
            this.f36737u = m.optString("id");
            this.f36738v = m.optString("create_time");
            this.f36739w = m38876a(m.getJSONArray("transactions"));
        } catch (JSONException e) {
            mo38507d();
        }
    }

    /* renamed from: d */
    public final void mo38507d() {
        mo38594a(mo38515m());
    }

    /* renamed from: t */
    public final boolean mo38583t() {
        return this.f36734r;
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public final C11815eq mo38584u() {
        return this.f36730n;
    }

    /* renamed from: v */
    public final String mo38585v() {
        return this.f36736t;
    }

    /* renamed from: w */
    public final String mo38586w() {
        return this.f36737u;
    }

    /* renamed from: x */
    public final String mo38587x() {
        return this.f36735s;
    }

    /* renamed from: y */
    public final String mo38588y() {
        return this.f36738v;
    }

    /* renamed from: z */
    public final String mo38589z() {
        return this.f36739w;
    }
}
