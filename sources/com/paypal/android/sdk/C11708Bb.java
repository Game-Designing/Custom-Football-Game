package com.paypal.android.sdk;

import com.mopub.common.AdType;
import com.mopub.common.Constants;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: com.paypal.android.sdk.Bb */
public final class C11708Bb extends C11744Lb {

    /* renamed from: A */
    private String f36580A;

    /* renamed from: B */
    private String f36581B;

    /* renamed from: m */
    private String f36582m;

    /* renamed from: n */
    private String f36583n;

    /* renamed from: o */
    private JSONArray f36584o;

    /* renamed from: p */
    private JSONObject f36585p;

    /* renamed from: q */
    private JSONArray f36586q;

    /* renamed from: r */
    private C11815eq f36587r;

    /* renamed from: s */
    private Map f36588s;

    /* renamed from: t */
    private C11738Jb[] f36589t;

    /* renamed from: u */
    private String f36590u;

    /* renamed from: v */
    private boolean f36591v;

    /* renamed from: w */
    private String f36592w;

    /* renamed from: x */
    private boolean f36593x;

    /* renamed from: y */
    private String f36594y;

    /* renamed from: z */
    private String f36595z;

    public C11708Bb(C11707Ba ba, C11706B b, String str, String str2, String str3, C11815eq eqVar, Map map, C11738Jb[] jbArr, String str4, boolean z, String str5, String str6, String str7, boolean z2) {
        super(C11740Ka.CreateSfoPaymentRequest, ba, b, str);
        this.f36587r = eqVar;
        this.f36588s = map;
        this.f36589t = jbArr;
        this.f36590u = str4;
        this.f36593x = z2;
        this.f36592w = str7;
        if (C11723Fa.m38818a((CharSequence) this.f36592w)) {
            this.f36592w = "sale";
        }
        this.f36592w = this.f36592w.toLowerCase(Locale.US);
        mo38500a("PayPal-Request-Id", str2);
        if (C11723Fa.m38822b((CharSequence) str5)) {
            mo38500a("PayPal-Partner-Attribution-Id", str5);
        }
        if (C11723Fa.m38822b((CharSequence) str6)) {
            mo38500a("PayPal-Client-Metadata-Id", str6);
        }
    }

    /* renamed from: a */
    public final C11708Bb mo38533a(boolean z) {
        this.f36591v = z;
        return this;
    }

    /* renamed from: b */
    public final String mo38503b() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.accumulate(Constants.INTENT_SCHEME, this.f36592w);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.accumulate("payment_method", "paypal");
        jSONObject2.accumulate("payer", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.accumulate("cancel_url", "http://cancelurl");
        jSONObject4.accumulate("return_url", "http://returnurl");
        jSONObject2.accumulate("redirect_urls", jSONObject4);
        C11815eq eqVar = this.f36587r;
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.accumulate("currency", eqVar.mo38780b().getCurrencyCode());
        jSONObject5.accumulate("total", eqVar.mo38779a().toPlainString());
        Map map = this.f36588s;
        if (map != null && !map.isEmpty()) {
            Map map2 = this.f36588s;
            if (map2 == null || map2.isEmpty()) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                String str = "shipping";
                if (this.f36588s.containsKey(str)) {
                    jSONObject.accumulate(str, this.f36588s.get(str));
                }
                String str2 = "subtotal";
                if (this.f36588s.containsKey(str2)) {
                    jSONObject.accumulate(str2, this.f36588s.get(str2));
                }
                String str3 = "tax";
                if (this.f36588s.containsKey(str3)) {
                    jSONObject.accumulate(str3, this.f36588s.get(str3));
                }
            }
            jSONObject5.accumulate("details", jSONObject);
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.accumulate("amount", jSONObject5);
        jSONObject6.accumulate(Repo.COLUMN_DESCRIPTION, this.f36590u);
        C11738Jb[] jbArr = this.f36589t;
        if (jbArr != null && jbArr.length > 0) {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.accumulate(Repo.COLUMN_ITEMS, C11738Jb.m38869a(this.f36589t));
            jSONObject6.accumulate("item_list", jSONObject7);
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject6);
        jSONObject2.accumulate("transactions", jSONArray);
        if (C11723Fa.m38822b((CharSequence) this.f36594y)) {
            jSONObject6.accumulate("invoice_number", this.f36594y);
        }
        if (C11723Fa.m38822b((CharSequence) this.f36595z)) {
            jSONObject6.accumulate(AdType.CUSTOM, this.f36595z);
        }
        if (C11723Fa.m38822b((CharSequence) this.f36580A)) {
            jSONObject6.accumulate("soft_descriptor", this.f36580A);
        }
        if (C11723Fa.m38822b((CharSequence) this.f36581B)) {
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.accumulate("email", this.f36581B);
            jSONObject6.accumulate("payee", jSONObject8);
        }
        JSONObject jSONObject9 = new JSONObject();
        jSONObject9.accumulate("device_info", C11723Fa.m38812a(C11844lb.m39198a().toString()));
        jSONObject9.accumulate("app_info", C11723Fa.m38812a(C11828hb.m39167a().toString()));
        jSONObject9.accumulate("risk_data", C11723Fa.m38812a(C12010u.m39718a().mo39195c().toString()));
        JSONObject jSONObject10 = new JSONObject();
        jSONObject10.accumulate("payment", jSONObject2);
        jSONObject10.accumulate("client_info", jSONObject9);
        if (this.f36593x) {
            jSONObject10.accumulate("retrieve_shipping_addresses", Boolean.valueOf(true));
        }
        jSONObject10.accumulate("no_shipping", Boolean.valueOf(this.f36591v));
        return jSONObject10.toString();
    }

    /* renamed from: c */
    public final void mo38505c() {
        JSONObject m = mo38515m();
        this.f36582m = m.optString("payment_id");
        this.f36583n = m.getString("session_id");
        this.f36584o = m.optJSONArray("addresses");
        JSONObject optJSONObject = m.optJSONObject("funding_options");
        if (optJSONObject != null) {
            this.f36585p = optJSONObject.optJSONObject("default_option");
            this.f36586q = optJSONObject.optJSONArray("alternate_options");
        }
    }

    /* renamed from: d */
    public final C11708Bb mo38534d(String str) {
        this.f36594y = str;
        return this;
    }

    /* renamed from: d */
    public final void mo38507d() {
        mo38594a(mo38515m());
    }

    /* renamed from: e */
    public final C11708Bb mo38535e(String str) {
        this.f36595z = str;
        return this;
    }

    /* renamed from: e */
    public final String mo38508e() {
        return "{    \"session_id\":\"7N0112287V303050T\",    \"payment_id\":\"PAY-18X32451H0459092JKO7KFUI\",    \"addresses\": [          {             \"city\": \"Columbia\",              \"line2\": \"6073 2nd Street\",              \"line1\": \"Suite 222\",              \"recipient_name\": \"Beverly Jello\",             \"state\": \"MD\",              \"postal_code\": \"21045\",             \"default_address\": false,              \"country_code\": \"US\",              \"type\": \"HOME_OR_WORK\",              \"id\": \"366853\"          },          {             \"city\": \"Austin\",              \"line2\": \"Apt. 222\",              \"line1\": \"52 North Main St. \",              \"recipient_name\": \"Michael Chassen\",             \"state\": \"TX\",              \"postal_code\": \"78729\",             \"default_address\": true,              \"country_code\": \"US\",              \"type\": \"HOME_OR_WORK\",              \"id\": \"366852\"          },          {             \"city\": \"Austin\",              \"line1\": \"202 South State St. \",              \"recipient_name\": \"Sam Stone\",             \"state\": \"TX\",              \"postal_code\": \"78729\",             \"default_address\": true,              \"country_code\": \"US\",              \"type\": \"HOME_OR_WORK\",              \"id\": \"366852\"          }     ],     \"funding_options\":{       \"default_option\":{          \"id\":\"1\",          \"backup_funding_instrument\":{             \"payment_card\":{                \"number\":\"8029\",                \"type\":\"VISA\"             }          },          \"funding_sources\":[             {                \"amount\":{                   \"value\":\"216.85\",                   \"currency\":\"USD\"                },                \"funding_instrument_type\":\"BANK_ACCOUNT\",                \"funding_mode\":\"INSTANT_TRANSFER\",                \"bank_account\":{                   \"bank_name\":\"SunTrust\",                   \"account_number\":\"7416\",                   \"account_number_type\":\"BBAN\",                   \"country_code\":\"US\",                   \"account_type\":\"CHECKING\"                }             },             {                \"amount\":{                   \"value\":\"6.00\",                   \"currency\":\"USD\"                },                \"funding_instrument_type\":\"CREDIT\",                \"funding_mode\":\"INSTANT_TRANSFER\",                \"credit\":{                   \"type\":\"BILL_ME_LATER\",                   \"id\":\"mock-id\"                }             }          ]       },       \"alternate_options\":[          {             \"id\":\"2\",             \"funding_sources\":[                {                   \"amount\":{                      \"value\":\"216.85\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"PAYMENT_CARD\",                   \"payment_card\":{                      \"number\":\"8029\",                      \"type\":\"VISA\"                   },                   \"funding_mode\":\"INSTANT_TRANSFER\"                },                {                   \"amount\":{                      \"value\":\"6.00\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"BALANCE\",                   \"funding_mode\":\"INSTANT_TRANSFER\"                }             ]          },          {             \"id\":\"3\",             \"funding_sources\":[                {                   \"amount\":{                      \"value\":\"216.85\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"PAYMENT_CARD\",                   \"payment_card\":{                      \"number\":\"8011\",                      \"type\":\"VISA\"                   },                   \"funding_mode\":\"INSTANT_TRANSFER\"                },                {                   \"amount\":{                      \"value\":\"6.00\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"BALANCE\",                   \"funding_mode\":\"INSTANT_TRANSFER\"                }             ]          }       ]    } }";
    }

    /* renamed from: f */
    public final C11708Bb mo38536f(String str) {
        this.f36580A = str;
        return this;
    }

    /* renamed from: g */
    public final C11708Bb mo38537g(String str) {
        this.f36581B = str;
        return this;
    }

    /* renamed from: t */
    public final String mo38538t() {
        return this.f36582m;
    }

    /* renamed from: u */
    public final String mo38539u() {
        return this.f36583n;
    }

    /* renamed from: v */
    public final JSONArray mo38540v() {
        return this.f36584o;
    }

    /* renamed from: w */
    public final JSONObject mo38541w() {
        return this.f36585p;
    }

    /* renamed from: x */
    public final JSONArray mo38542x() {
        return this.f36586q;
    }
}
