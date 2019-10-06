package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

public final class zzblz implements zzbls {

    /* renamed from: a */
    private final Context f25514a;

    public zzblz(Context context) {
        this.f25514a = context;
    }

    /* renamed from: a */
    public final void mo30727a(Map<String, String> map) {
        String str = (String) map.get("cookie");
        if (!TextUtils.isEmpty(str)) {
            CookieManager c = zzk.zzli().mo30259c(this.f25514a);
            if (c != null) {
                c.setCookie("googleads.g.doubleclick.net", str);
            }
        }
    }
}
