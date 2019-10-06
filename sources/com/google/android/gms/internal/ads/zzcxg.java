package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxg implements zzcuz<JSONObject> {

    /* renamed from: a */
    private final Map<String, Object> f27528a;

    public zzcxg(Map<String, Object> map) {
        this.f27528a = map;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzk.zzlg().mo30230a(this.f27528a));
        } catch (JSONException e) {
            String str = "Could not encode video decoder properties: ";
            String valueOf = String.valueOf(e.getMessage());
            zzawz.m26003f(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
