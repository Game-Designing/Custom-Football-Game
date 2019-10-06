package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxq implements zzazf {

    /* renamed from: a */
    public final String f27585a = this.f27588d.optString("ad_html", null);

    /* renamed from: b */
    public final String f27586b = this.f27588d.optString("ad_base_url", null);

    /* renamed from: c */
    public final JSONObject f27587c = this.f27588d.optJSONObject("ad_json");

    /* renamed from: d */
    private final JSONObject f27588d;

    zzcxq(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        this.f27588d = zzazc.m26273c(jsonReader);
    }

    /* renamed from: a */
    public final void mo30296a(JsonWriter jsonWriter) throws IOException {
        zzazc.m26269a(jsonWriter, this.f27588d);
    }
}
