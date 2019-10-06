package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zzajr {
    /* renamed from: a */
    public static void m25124a(zzajq zzajq, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzajq.mo29037a(str, jSONObject.toString());
    }

    /* renamed from: a */
    public static void m25122a(zzajq zzajq, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzajq.mo28724a(sb.toString());
    }

    /* renamed from: b */
    public static void m25125b(zzajq zzajq, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String str2 = "Dispatching AFMA event: ";
        String valueOf = String.valueOf(sb.toString());
        zzbad.m26352a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        zzajq.mo28724a(sb.toString());
    }

    /* renamed from: a */
    public static void m25123a(zzajq zzajq, String str, Map map) {
        try {
            zzajq.mo28730a(str, zzk.zzlg().mo30230a(map));
        } catch (JSONException e) {
            zzbad.m26359d("Could not convert parameters to JSON.");
        }
    }
}
