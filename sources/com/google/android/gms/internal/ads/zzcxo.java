package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

public final class zzcxo {

    /* renamed from: a */
    public final List<String> f27579a;

    /* renamed from: b */
    public final String f27580b;

    /* renamed from: c */
    public final int f27581c;

    /* renamed from: d */
    public final String f27582d;

    /* renamed from: e */
    public final int f27583e;

    /* renamed from: f */
    public final long f27584f;

    zzcxo(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<String> emptyList = Collections.emptyList();
        jsonReader.beginObject();
        String str = "";
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str2 = str;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("nofill_urls".equals(nextName)) {
                emptyList = zzazc.m26262a(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("response_code".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j = jsonReader.nextLong();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        this.f27579a = emptyList;
        this.f27581c = i;
        this.f27580b = str;
        this.f27582d = str2;
        this.f27583e = i2;
        this.f27584f = j;
    }
}
