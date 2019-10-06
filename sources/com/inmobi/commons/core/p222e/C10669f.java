package com.inmobi.commons.core.p222e;

import android.content.ContentValues;
import java.util.UUID;

/* renamed from: com.inmobi.commons.core.e.f */
/* compiled from: TelemetryEvent */
public class C10669f {

    /* renamed from: g */
    private static final String f32533g = C10669f.class.getSimpleName();

    /* renamed from: a */
    int f32534a;

    /* renamed from: b */
    String f32535b;

    /* renamed from: c */
    String f32536c;

    /* renamed from: d */
    String f32537d;

    /* renamed from: e */
    long f32538e;

    /* renamed from: f */
    String f32539f;

    public C10669f(String str, String str2) {
        this.f32535b = UUID.randomUUID().toString();
        this.f32537d = str;
        this.f32536c = str2;
        this.f32539f = null;
        this.f32538e = System.currentTimeMillis();
    }

    private C10669f(String str, String str2, String str3, String str4) {
        this.f32535b = str;
        this.f32537d = str2;
        this.f32536c = str3;
        this.f32539f = str4;
        this.f32538e = System.currentTimeMillis();
    }

    /* renamed from: a */
    public final String mo34494a() {
        String str = this.f32539f;
        return str == null ? "" : str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f32536c);
        sb.append("@");
        sb.append(this.f32537d);
        sb.append(" ");
        return sb.toString();
    }

    /* renamed from: a */
    public static C10669f m35017a(ContentValues contentValues) {
        String asString = contentValues.getAsString("eventId");
        String asString2 = contentValues.getAsString("eventType");
        String asString3 = contentValues.getAsString("componentType");
        String asString4 = contentValues.getAsString("payload");
        long longValue = Long.valueOf(contentValues.getAsString("ts")).longValue();
        C10669f fVar = new C10669f(asString, asString3, asString2, asString4);
        fVar.f32538e = longValue;
        fVar.f32534a = contentValues.getAsInteger("id").intValue();
        return fVar;
    }
}
