package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcvn implements zzcuz<JSONObject> {

    /* renamed from: a */
    private final Context f27461a;

    /* renamed from: b */
    private final Info f27462b;

    /* renamed from: c */
    private final String f27463c;

    public zzcvn(Info info, Context context, String str) {
        this.f27461a = context;
        this.f27462b = info;
        this.f27463c = str;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        try {
            JSONObject a = zzazc.m26265a((JSONObject) obj, "pii");
            String str = null;
            boolean z = false;
            if (this.f27462b != null) {
                str = this.f27462b.getId();
                z = this.f27462b.isLimitAdTrackingEnabled();
            }
            if (!TextUtils.isEmpty(str)) {
                a.put("rdid", str);
                a.put("is_lat", z);
                a.put("idtype", "adid");
                return;
            }
            a.put("pdid", this.f27463c);
            a.put("pdidtype", "ssaid");
        } catch (JSONException e) {
            zzawz.m26002e("Failed putting Ad ID.", e);
        }
    }
}
