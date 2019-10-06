package com.moat.analytics.mobile.sma;

import android.os.Build.VERSION;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.sma.l */
class C11101l {

    /* renamed from: a */
    private boolean f33939a = false;

    /* renamed from: b */
    private boolean f33940b = false;

    /* renamed from: c */
    private boolean f33941c = false;

    /* renamed from: d */
    private int f33942d = 200;

    C11101l(String str) {
        m36535a(str);
    }

    /* renamed from: a */
    private void m36535a(String str) {
        String str2 = "in";
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("sa");
                boolean equals = string.equals("953154ac4464acdcdc8f392f879c5bd5798cd286");
                boolean equals2 = string.equals("8f1d08a2d6496191a5ebae8f0590f513e2619489");
                if ((string.equals("on") || equals || equals2) && !m36536a(jSONObject) && !m36537b(jSONObject)) {
                    this.f33939a = true;
                    this.f33940b = equals;
                    this.f33941c = equals2;
                    if (this.f33941c) {
                        this.f33940b = true;
                    }
                }
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2);
                    if (i >= 100 && i <= 1000) {
                        this.f33942d = i;
                    }
                }
                if (m36538c(jSONObject)) {
                    ((C11100k) MoatAnalytics.getInstance()).f33934c = true;
                }
            } catch (Exception e) {
                this.f33939a = false;
                this.f33940b = false;
                this.f33942d = 200;
                C11102m.m36543a(e);
            }
        }
    }

    /* renamed from: a */
    private boolean m36536a(JSONObject jSONObject) {
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
    private boolean m36537b(JSONObject jSONObject) {
        String str = "ap";
        try {
            if (jSONObject.has(str)) {
                String b = new C11115a().mo36252b();
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).contentEquals(b)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
        return false;
    }

    /* renamed from: c */
    private boolean m36538c(JSONObject jSONObject) {
        String str = "al";
        try {
            if (jSONObject.has(str)) {
                String b = new C11115a().mo36252b();
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).contentEquals(b)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo36237a() {
        return this.f33940b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36238b() {
        return this.f33941c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo36239c() {
        return this.f33942d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C11132d mo36240d() {
        return this.f33939a ? C11132d.ON : C11132d.OFF;
    }
}
