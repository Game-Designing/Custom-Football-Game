package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.Gc */
final /* synthetic */ class C8868Gc implements C8952Kc {

    /* renamed from: a */
    private final String f20883a;

    /* renamed from: b */
    private final String f20884b;

    /* renamed from: c */
    private final Map f20885c;

    /* renamed from: d */
    private final byte[] f20886d;

    C8868Gc(String str, String str2, Map map, byte[] bArr) {
        this.f20883a = str;
        this.f20884b = str2;
        this.f20885c = map;
        this.f20886d = bArr;
    }

    /* renamed from: a */
    public final void mo28250a(JsonWriter jsonWriter) {
        zzazx.m26331a(this.f20883a, this.f20884b, this.f20885c, this.f20886d, jsonWriter);
    }
}
