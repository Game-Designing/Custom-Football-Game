package com.inmobi.commons.core.utilities.p225b;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.utilities.b.h */
/* compiled from: SessionInfo */
public class C10698h {

    /* renamed from: e */
    private static final String f32648e = C10698h.class.getSimpleName();

    /* renamed from: f */
    private static C10698h f32649f;

    /* renamed from: g */
    private static final Object f32650g = new Object();

    /* renamed from: a */
    public String f32651a;

    /* renamed from: b */
    public long f32652b;

    /* renamed from: c */
    public long f32653c;

    /* renamed from: d */
    boolean f32654d;

    /* renamed from: a */
    public static C10698h m35136a() {
        C10698h hVar = f32649f;
        if (hVar == null) {
            synchronized (f32650g) {
                hVar = f32649f;
                if (hVar == null) {
                    hVar = new C10698h();
                    f32649f = hVar;
                }
            }
        }
        return hVar;
    }

    private C10698h() {
    }

    /* renamed from: b */
    public final JSONObject mo34522b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", this.f32651a);
            jSONObject.put("s-ts", this.f32652b);
            jSONObject.put("e-ts", this.f32653c);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final void mo34521a(boolean z) {
        this.f32654d = z;
        if (!this.f32654d) {
            this.f32651a = null;
            this.f32652b = 0;
            this.f32653c = 0;
        }
    }
}
