package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcwt implements zzcuz<JSONObject> {

    /* renamed from: a */
    private Bundle f27515a;

    public zzcwt(Bundle bundle) {
        this.f27515a = bundle;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.f27515a != null) {
            try {
                zzazc.m26265a(zzazc.m26265a(jSONObject, "device"), "play_store").put("parental_controls", zzk.zzlg().mo30228a(this.f27515a));
            } catch (JSONException e) {
                zzawz.m26003f("Failed putting parental controls bundle.");
            }
        }
    }
}
