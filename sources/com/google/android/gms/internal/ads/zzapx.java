package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzapx {

    /* renamed from: a */
    private final boolean f24558a;

    /* renamed from: b */
    private final boolean f24559b;

    /* renamed from: c */
    private final boolean f24560c;

    /* renamed from: d */
    private final boolean f24561d;

    /* renamed from: e */
    private final boolean f24562e;

    private zzapx(zzapz zzapz) {
        this.f24558a = zzapz.f24563a;
        this.f24559b = zzapz.f24564b;
        this.f24560c = zzapz.f24565c;
        this.f24561d = zzapz.f24566d;
        this.f24562e = zzapz.f24567e;
    }

    /* renamed from: a */
    public final JSONObject mo29982a() {
        try {
            return new JSONObject().put("sms", this.f24558a).put("tel", this.f24559b).put("calendar", this.f24560c).put("storePicture", this.f24561d).put("inlineVideo", this.f24562e);
        } catch (JSONException e) {
            zzbad.m26356b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
