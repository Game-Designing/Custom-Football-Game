package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzblx implements zzbls {

    /* renamed from: a */
    private final zzcxk f25512a;

    public zzblx(zzcxk zzcxk) {
        this.f25512a = zzcxk;
    }

    /* renamed from: a */
    public final void mo30727a(Map<String, String> map) {
        String str = (String) map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f25512a.mo31281a(Boolean.parseBoolean(str));
            } catch (Exception e) {
                throw new IllegalStateException("Invalid render_in_browser state");
            }
        }
    }
}
