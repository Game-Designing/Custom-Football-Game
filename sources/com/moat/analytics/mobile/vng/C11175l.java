package com.moat.analytics.mobile.vng;

import android.os.Build.VERSION;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.l */
class C11175l {

    /* renamed from: a */
    private boolean f34126a = false;

    /* renamed from: b */
    private boolean f34127b = false;

    /* renamed from: c */
    private boolean f34128c = false;

    /* renamed from: d */
    private int f34129d = 200;

    C11175l(String str) {
        m36775a(str);
    }

    /* renamed from: a */
    private void m36775a(String str) {
        String str2 = "in";
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("sa");
                boolean equals = string.equals("3f2ae9c1894282b5e0222f0d06bbf457191f816f");
                boolean equals2 = string.equals("8f1d08a2d6496191a5ebae8f0590f513e2619489");
                if ((string.equals("on") || equals || equals2) && !m36776a(jSONObject) && !m36777b(jSONObject)) {
                    this.f34126a = true;
                    this.f34127b = equals;
                    this.f34128c = equals2;
                    if (this.f34128c) {
                        this.f34127b = true;
                    }
                }
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2);
                    if (i >= 100 && i <= 1000) {
                        this.f34129d = i;
                    }
                }
                if (m36778c(jSONObject)) {
                    ((C11174k) MoatAnalytics.getInstance()).f34121c = true;
                }
            } catch (Exception e) {
                this.f34126a = false;
                this.f34127b = false;
                this.f34129d = 200;
                C11176m.m36783a(e);
            }
        }
    }

    /* renamed from: a */
    private boolean m36776a(JSONObject jSONObject) {
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
    private boolean m36777b(JSONObject jSONObject) {
        String str = "ap";
        try {
            if (jSONObject.has(str)) {
                String b = new C11189a().mo36384b();
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).contentEquals(b)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
        return false;
    }

    /* renamed from: c */
    private boolean m36778c(JSONObject jSONObject) {
        String str = "al";
        try {
            if (jSONObject.has(str)) {
                String b = new C11189a().mo36384b();
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).contentEquals(b)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo36369a() {
        return this.f34127b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36370b() {
        return this.f34128c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo36371c() {
        return this.f34129d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C11206d mo36372d() {
        return this.f34126a ? C11206d.ON : C11206d.OFF;
    }
}
