package com.inmobi.rendering.mraid;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.mraid.g */
/* compiled from: OrientationProperties */
public class C10785g {

    /* renamed from: e */
    private static String f32952e = C10785g.class.getSimpleName();

    /* renamed from: a */
    public boolean f32953a = true;

    /* renamed from: b */
    public String f32954b = "none";

    /* renamed from: c */
    public String f32955c = "right";

    /* renamed from: d */
    public String f32956d = null;

    /* renamed from: a */
    public static C10785g m35358a(String str, C10785g gVar) {
        String str2 = "right";
        C10785g gVar2 = new C10785g();
        gVar2.f32956d = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            gVar2.f32954b = jSONObject.optString("forceOrientation", gVar.f32954b);
            gVar2.f32953a = jSONObject.optBoolean("allowOrientationChange", gVar.f32953a);
            gVar2.f32955c = jSONObject.optString("direction", gVar.f32955c);
            if (!gVar2.f32954b.equals("portrait") && !gVar2.f32954b.equals("landscape")) {
                gVar2.f32954b = "none";
            }
            if (gVar2.f32955c.equals("left") || gVar2.f32955c.equals(str2)) {
                return gVar2;
            }
            gVar2.f32955c = str2;
            return gVar2;
        } catch (JSONException e) {
            return null;
        }
    }
}
