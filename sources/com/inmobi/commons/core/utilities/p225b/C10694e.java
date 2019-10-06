package com.inmobi.commons.core.utilities.p225b;

import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.configs.C10652h;
import com.inmobi.sdk.InMobiSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.utilities.b.e */
/* compiled from: GDPRInfo */
public final class C10694e {

    /* renamed from: a */
    private static final String f32630a = C10694e.class.getName();

    /* renamed from: b */
    private static JSONObject f32631b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static C10652h f32632c = new C10652h();

    /* renamed from: d */
    private static C10644c f32633d = new C10644c() {
        /* renamed from: a */
        public final void mo33666a(C10639a aVar) {
            C10694e.f32632c = (C10652h) aVar;
        }
    };

    private C10694e() {
    }

    /* renamed from: a */
    public static JSONObject m35110a() {
        return f32631b;
    }

    /* renamed from: a */
    public static void m35111a(JSONObject jSONObject) {
        f32631b = jSONObject;
    }

    /* renamed from: c */
    public static void m35113c() {
        C10641b.m34915a().mo34452a((C10639a) f32632c, f32633d);
    }

    /* renamed from: d */
    public static int m35114d() {
        return m35108a(false);
    }

    /* renamed from: a */
    public static int m35108a(boolean z) {
        int i = f32632c.f32474d;
        int f = m35116f();
        if (f == 1 || i == 1 || z) {
            return 1;
        }
        if (i == 0 || i != -1 || f == 0) {
            return 0;
        }
        return 1;
    }

    /* renamed from: f */
    private static int m35116f() {
        JSONObject jSONObject = f32631b;
        if (jSONObject != null) {
            String str = InMobiSdk.IM_GDPR_CONSENT_AVAILABLE;
            if (jSONObject.has(str)) {
                try {
                    return jSONObject.getBoolean(str) ? 1 : 0;
                } catch (JSONException e) {
                    return -1;
                }
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static boolean m35112b() {
        String str = InMobiSdk.IM_GDPR_CONSENT_AVAILABLE;
        JSONObject jSONObject = f32631b;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str) && !jSONObject.getBoolean(str)) {
                    return true;
                }
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m35115e() {
        if (m35108a(false) != 0) {
            return true;
        }
        return false;
    }
}
