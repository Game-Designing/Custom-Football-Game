package com.inmobi.commons.core.p218a;

import android.content.ContentValues;
import android.util.Log;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.a.d */
/* compiled from: CrashEvent */
public class C10628d {

    /* renamed from: g */
    private static final String f32383g = C10628d.class.getSimpleName();

    /* renamed from: a */
    int f32384a;

    /* renamed from: b */
    String f32385b;

    /* renamed from: c */
    String f32386c;

    /* renamed from: d */
    String f32387d;

    /* renamed from: e */
    long f32388e;

    /* renamed from: f */
    public String f32389f;

    public C10628d(Thread thread, Throwable th) {
        this("crashReporting", "CrashEvent");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", th.getClass().getSimpleName());
            jSONObject.put("message", th.getMessage());
            jSONObject.put("stack", Log.getStackTraceString(th));
            jSONObject.put("thread", thread.getName());
            this.f32389f = jSONObject.toString();
        } catch (JSONException e) {
            new StringBuilder("JSONException: ").append(e);
        }
    }

    public C10628d(String str, String str2) {
        this.f32385b = UUID.randomUUID().toString();
        this.f32387d = str;
        this.f32386c = str2;
        this.f32389f = null;
        this.f32388e = System.currentTimeMillis();
    }

    private C10628d(String str, String str2, String str3, String str4) {
        this.f32385b = str;
        this.f32387d = str2;
        this.f32386c = str3;
        this.f32389f = str4;
        this.f32388e = System.currentTimeMillis();
    }

    /* renamed from: a */
    public final String mo34435a() {
        String str = this.f32389f;
        return str == null ? "" : str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f32386c);
        sb.append("@");
        sb.append(this.f32387d);
        sb.append(" ");
        return sb.toString();
    }

    /* renamed from: a */
    public static C10628d m34881a(ContentValues contentValues) {
        String asString = contentValues.getAsString("eventId");
        String asString2 = contentValues.getAsString("eventType");
        String asString3 = contentValues.getAsString("componentType");
        String asString4 = contentValues.getAsString("payload");
        long longValue = Long.valueOf(contentValues.getAsString("ts")).longValue();
        C10628d dVar = new C10628d(asString, asString3, asString2, asString4);
        dVar.f32388e = longValue;
        dVar.f32384a = contentValues.getAsInteger("id").intValue();
        return dVar;
    }
}
