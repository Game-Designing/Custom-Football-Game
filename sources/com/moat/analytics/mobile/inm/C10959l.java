package com.moat.analytics.mobile.inm;

import android.os.Build.VERSION;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.l */
class C10959l {

    /* renamed from: a */
    private boolean f33514a = false;

    /* renamed from: b */
    private boolean f33515b = false;

    /* renamed from: c */
    private boolean f33516c = false;

    /* renamed from: d */
    private int f33517d = 200;

    /* renamed from: e */
    private int f33518e = 10;

    C10959l(String str) {
        m36066a(str);
    }

    /* renamed from: a */
    private void m36066a(String str) {
        String str2 = "es";
        String str3 = "in";
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("sa");
                boolean equals = string.equals("c334ae83accfebb8da23104450c896463c9cfab7");
                boolean equals2 = string.equals("8f1d08a2d6496191a5ebae8f0590f513e2619489");
                if ((string.equals("on") || equals || equals2) && !m36067a(jSONObject) && !m36068b(jSONObject)) {
                    this.f33514a = true;
                    this.f33515b = equals;
                    this.f33516c = equals2;
                    if (this.f33516c) {
                        this.f33515b = true;
                    }
                }
                if (jSONObject.has(str3)) {
                    int i = jSONObject.getInt(str3);
                    if (i >= 100 && i <= 1000) {
                        this.f33517d = i;
                    }
                }
                if (jSONObject.has(str2)) {
                    this.f33518e = jSONObject.getInt(str2);
                }
                if (m36069c(jSONObject)) {
                    ((C10958k) MoatAnalytics.getInstance()).f33508c = true;
                }
            } catch (Exception e) {
                this.f33514a = false;
                this.f33515b = false;
                this.f33517d = 200;
                C10960m.m36077a(e);
            }
        }
    }

    /* renamed from: a */
    private boolean m36067a(JSONObject jSONObject) {
        String str = "ob";
        try {
            if (16 > VERSION.SDK_INT) {
                return true;
            }
            if (jSONObject.has(str)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getInt(i) == VERSION.SDK_INT) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    /* renamed from: b */
    private boolean m36068b(JSONObject jSONObject) {
        String str = "ap";
        try {
            if (jSONObject.has(str)) {
                String b = C10972s.m36127d().mo35973b();
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).contentEquals(b)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
        return false;
    }

    /* renamed from: c */
    private boolean m36069c(JSONObject jSONObject) {
        String str = "al";
        try {
            if (jSONObject.has(str)) {
                String b = C10972s.m36127d().mo35973b();
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).contentEquals(b)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo35956a() {
        return this.f33515b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo35957b() {
        return this.f33516c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo35958c() {
        return this.f33517d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo35959d() {
        return this.f33518e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C10992d mo35960e() {
        return this.f33514a ? C10992d.ON : C10992d.OFF;
    }
}
