package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzalo {

    /* renamed from: a */
    private static final Charset f24410a = Charset.forName("UTF-8");

    /* renamed from: b */
    public static final zzaln<JSONObject> f24411b = new C8824Ea();

    /* renamed from: c */
    public static final zzall<InputStream> f24412c = C8803Da.f20576a;

    /* renamed from: a */
    static final /* synthetic */ InputStream m25202a(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(f24410a));
    }
}
