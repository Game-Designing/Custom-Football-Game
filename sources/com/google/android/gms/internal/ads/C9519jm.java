package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.jm */
final /* synthetic */ class C9519jm implements zzcuz {

    /* renamed from: a */
    static final zzcuz f22623a = new C9519jm();

    private C9519jm() {
    }

    /* renamed from: a */
    public final void mo28065a(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451009);
        } catch (JSONException e) {
        }
    }
}
