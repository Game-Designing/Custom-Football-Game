package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.p225b.C10692c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.mraid.b */
/* compiled from: ExpandProperties */
public class C10778b {

    /* renamed from: d */
    private static final String f32928d = C10778b.class.getSimpleName();

    /* renamed from: a */
    public boolean f32929a = false;

    /* renamed from: b */
    public boolean f32930b;

    /* renamed from: c */
    public String f32931c;

    /* renamed from: e */
    private int f32932e = C10692c.m35104a().f32627a;

    /* renamed from: f */
    private int f32933f = C10692c.m35104a().f32628b;

    /* renamed from: g */
    private boolean f32934g = true;

    public C10778b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", this.f32932e);
            jSONObject.put("height", this.f32933f);
            jSONObject.put("useCustomClose", this.f32929a);
            jSONObject.put("isModal", this.f32934g);
        } catch (JSONException e) {
            new StringBuilder("Exception in composing ExpandProperties: ").append(e.getMessage());
        }
        this.f32931c = jSONObject.toString();
    }

    /* renamed from: a */
    public static C10778b m35349a(String str) {
        String str2 = "useCustomClose";
        C10778b bVar = new C10778b();
        bVar.f32931c = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f32934g = true;
            if (jSONObject.has(str2)) {
                bVar.f32930b = true;
            }
            bVar.f32929a = jSONObject.optBoolean(str2, false);
        } catch (JSONException e) {
        }
        return bVar;
    }
}
