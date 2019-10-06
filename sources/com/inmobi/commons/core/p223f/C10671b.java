package com.inmobi.commons.core.p223f;

import android.content.ContentValues;

/* renamed from: com.inmobi.commons.core.f.b */
/* compiled from: TRCEvent */
public final class C10671b {

    /* renamed from: a */
    public int f32541a;

    /* renamed from: b */
    public String f32542b;

    /* renamed from: c */
    public String f32543c;

    /* renamed from: d */
    public String f32544d;

    /* renamed from: e */
    public long f32545e;

    /* renamed from: f */
    public String f32546f;

    /* renamed from: g */
    public String f32547g;

    /* renamed from: h */
    public String f32548h;

    /* renamed from: i */
    public long f32549i;

    /* renamed from: j */
    public String f32550j;

    /* renamed from: k */
    long f32551k = System.currentTimeMillis();

    public C10671b(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, long j2) {
        this.f32542b = str;
        this.f32543c = str2;
        this.f32544d = str3;
        this.f32545e = j;
        this.f32546f = str4;
        this.f32547g = str5;
        this.f32548h = str6;
        this.f32549i = j2;
        this.f32550j = str7;
    }

    /* renamed from: a */
    static C10671b m35032a(ContentValues contentValues) {
        String asString = contentValues.getAsString("eventId");
        String asString2 = contentValues.getAsString("adMarkup");
        String asString3 = contentValues.getAsString("eventName");
        long longValue = contentValues.getAsLong("imPlid").longValue();
        String asString4 = contentValues.getAsString("impressionId");
        String asString5 = contentValues.getAsString("eventType");
        String asString6 = contentValues.getAsString("dNettypeRaw");
        long longValue2 = contentValues.getAsLong("ts").longValue();
        String asString7 = contentValues.getAsString("adtype");
        long longValue3 = contentValues.getAsLong("timestamp").longValue();
        C10671b bVar = new C10671b(asString, asString2, asString3, longValue, asString4, asString5, asString6, asString7, longValue2);
        bVar.f32551k = longValue3;
        bVar.f32541a = contentValues.getAsInteger("id").intValue();
        return bVar;
    }
}
