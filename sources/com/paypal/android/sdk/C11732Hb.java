package com.paypal.android.sdk;

import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: com.paypal.android.sdk.Hb */
public final class C11732Hb extends C11735Ib {

    /* renamed from: A */
    public long f36685A;

    /* renamed from: q */
    public C11814eo f36686q;

    /* renamed from: r */
    public boolean f36687r;

    /* renamed from: s */
    private String f36688s;

    /* renamed from: t */
    private final boolean f36689t;

    /* renamed from: u */
    private final String f36690u;

    /* renamed from: v */
    private String f36691v;

    /* renamed from: w */
    private String f36692w;

    /* renamed from: x */
    public String f36693x;

    /* renamed from: y */
    public String f36694y;

    /* renamed from: z */
    public String f36695z;

    public C11732Hb(C11707Ba ba, C11706B b, String str, String str2, C11814eo eoVar, String str3, String str4, boolean z, String str5, boolean z2, String str6) {
        this(ba, b, str, str2, eoVar, z, str5, z2, str6);
        this.f36691v = str3;
        this.f36692w = str4;
    }

    public C11732Hb(C11707Ba ba, C11706B b, String str, String str2, C11814eo eoVar, boolean z, String str3, boolean z2, String str4) {
        super(C11740Ka.LoginRequest, ba, b, C11735Ib.m38862b(str, str2));
        this.f36686q = eoVar;
        this.f36687r = z;
        this.f36688s = str3;
        this.f36689t = z2;
        this.f36690u = str4;
    }

    /* renamed from: b */
    public final String mo38503b() {
        String e;
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("response_type", this.f36688s);
        String str2 = this.f36688s;
        if (str2 != null && str2.equals("token")) {
            hashMap.put("scope_consent_context", "access_token");
            if (!C11723Fa.m38818a((CharSequence) this.f36690u)) {
                hashMap.put("scope", this.f36690u);
            }
        }
        hashMap.put("risk_data", C11723Fa.m38812a(C12010u.m39718a().mo39195c().toString()));
        String str3 = "grant_type";
        if (this.f36691v != null) {
            hashMap.put(str3, "urn:paypal:params:oauth2:grant_type:otp");
            hashMap.put("nonce", this.f36692w);
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("token_identifier", "otp");
            jSONObject.accumulate("token_value", this.f36691v);
            e = C11735Ib.m38861a(jSONObject);
            str = "2fa_token_claims";
        } else {
            boolean a = this.f36686q.mo38772a();
            String str4 = Repo.COLUMN_PASSWORD;
            if (a) {
                hashMap.put(str3, str4);
                hashMap.put("email", C11723Fa.m38812a(this.f36686q.mo38773b()));
                hashMap.put(str4, C11723Fa.m38812a(this.f36686q.mo38774c()));
                hashMap.put("device_name", C11723Fa.m38812a(Build.DEVICE));
                hashMap.put("redirect_uri", C11723Fa.m38812a("urn:ietf:wg:oauth:2.0:oob"));
                return C11723Fa.m38813a((Map) hashMap);
            }
            hashMap.put(str3, str4);
            this.f36686q.mo38775d().mo38787c();
            StringBuilder sb = new StringBuilder("+");
            sb.append(this.f36686q.mo38775d().mo38787c());
            sb.append(" ");
            sb.append(this.f36686q.mo38775d().mo38784a());
            hashMap.put("phone", C11723Fa.m38812a(sb.toString()));
            e = this.f36686q.mo38777e();
            str = "pin";
        }
        hashMap.put(str, e);
        hashMap.put("device_name", C11723Fa.m38812a(Build.DEVICE));
        hashMap.put("redirect_uri", C11723Fa.m38812a("urn:ietf:wg:oauth:2.0:oob"));
        return C11723Fa.m38813a((Map) hashMap);
    }

    /* renamed from: c */
    public final void mo38505c() {
        String str = "scope";
        JSONObject m = mo38515m();
        try {
            m.getString(str);
            this.f36695z = m.getString(str);
            if (this.f36689t) {
                this.f36693x = m.getString("code");
                this.f36703n = m.getString("nonce");
                return;
            }
            this.f36694y = m.getString("access_token");
            this.f36685A = m.getLong("expires_in");
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
        return "{ \"access_token\": \"mock_access_token\", \"code\": \"mock_code_EJhi9jOPswug9TDOv93qg4Y28xIlqPDpAoqd7biDLpeGCPvORHjP1Fh4CbFPgKMGCHejdDwe9w1uDWnjPCp1lkaFBjVmjvjpFtnr6z1YeBbmfZYqa9faQT_71dmgZhMIFVkbi4yO7hk0LBHXt_wtdsw\", \"scope\": \"https://api.paypal.com/v1/payments/.*\", \"nonce\": \"mock_nonce\", \"token_type\": \"Bearer\",\"expires_in\":28800,\"visitor_id\":\"zVxjDBTRRNfYXdOb19-lcTblxm-6bzXGvSlP76ZiHOudKaAvoxrW8Cg5pA6EjIPpiz4zlw\" }";
    }

    /* renamed from: t */
    public final boolean mo38572t() {
        return this.f36691v != null;
    }
}
