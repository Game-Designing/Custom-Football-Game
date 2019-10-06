package com.inmobi.rendering.mraid;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.mraid.h */
/* compiled from: ResizeProperties */
public class C10786h {

    /* renamed from: g */
    private static final String f32957g = C10786h.class.getSimpleName();

    /* renamed from: a */
    String f32958a = "top-right";

    /* renamed from: b */
    int f32959b;

    /* renamed from: c */
    int f32960c;

    /* renamed from: d */
    int f32961d = 0;

    /* renamed from: e */
    int f32962e = 0;

    /* renamed from: f */
    boolean f32963f = true;

    /* renamed from: a */
    public static C10786h m35359a(String str, C10786h hVar) {
        C10786h hVar2 = new C10786h();
        try {
            JSONObject jSONObject = new JSONObject(str);
            hVar2.f32959b = jSONObject.getInt("width");
            hVar2.f32960c = jSONObject.getInt("height");
            hVar2.f32961d = jSONObject.getInt("offsetX");
            hVar2.f32962e = jSONObject.getInt("offsetY");
            if (hVar == null) {
                return hVar2;
            }
            hVar2.f32958a = jSONObject.optString("customClosePosition", hVar.f32958a);
            hVar2.f32963f = jSONObject.optBoolean("allowOffscreen", hVar.f32963f);
            return hVar2;
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: a */
    public final String mo34788a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.f32959b);
            jSONObject.put("height", this.f32960c);
            jSONObject.put("customClosePosition", this.f32958a);
            jSONObject.put("offsetX", this.f32961d);
            jSONObject.put("offsetY", this.f32962e);
            jSONObject.put("allowOffscreen", this.f32963f);
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
