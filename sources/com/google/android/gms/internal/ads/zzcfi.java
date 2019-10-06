package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.mopub.common.AdType;
import java.util.LinkedHashMap;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

public final class zzcfi {

    /* renamed from: a */
    private Map<String, String> f26525a = new LinkedHashMap();

    public zzcfi(Context context, String str) {
        Map<String, String> map = this.f26525a;
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", VERSION.RELEASE);
        map.put("sdk", VERSION.SDK);
        zzk.zzlg();
        map.put("device", zzaxi.m26121b());
        map.put("app", str);
        zzk.zzlg();
        map.put("is_lite_sdk", zzaxi.m26142j(context) ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        map.put("e", TextUtils.join(",", zzacu.m24784b()));
    }

    /* renamed from: a */
    public final void mo31144a(zzcxu zzcxu) {
        if (zzcxu.f27596b.f27590a.size() > 0) {
            int i = ((zzcxm) zzcxu.f27596b.f27590a.get(0)).f27551b;
            String str = "ad_format";
            if (i == 1) {
                this.f26525a.put(str, "banner");
            } else if (i == 2) {
                this.f26525a.put(str, AdType.INTERSTITIAL);
            } else if (i == 3) {
                this.f26525a.put(str, "native_express");
            } else if (i == 4) {
                this.f26525a.put(str, "native_advanced");
            } else if (i != 5) {
                this.f26525a.put(str, "unknown");
            } else {
                this.f26525a.put(str, "rewarded");
            }
            if (!TextUtils.isEmpty(zzcxu.f27596b.f27591b.f27580b)) {
                this.f26525a.put("gqi", zzcxu.f27596b.f27591b.f27580b);
            }
        }
    }

    /* renamed from: a */
    public final void mo31143a(Bundle bundle) {
        String str = "cnt";
        if (bundle.containsKey(str)) {
            this.f26525a.put("network_coarse", Integer.toString(bundle.getInt(str)));
        }
        String str2 = "gnt";
        if (bundle.containsKey(str2)) {
            this.f26525a.put("network_fine", Integer.toString(bundle.getInt(str2)));
        }
    }

    /* renamed from: a */
    public final Map<String, String> mo31142a() {
        return this.f26525a;
    }
}
