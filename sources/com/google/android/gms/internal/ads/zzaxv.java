package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
public class zzaxv extends zzaxu {
    /* renamed from: c */
    public final CookieManager mo30259c(Context context) {
        if (zzaxo.m26165c()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbad.m26356b("Failed to obtain CookieManager.", th);
            zzk.zzlk().mo30168a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    /* renamed from: a */
    public final zzbha mo30247a(zzbgz zzbgz, zzwj zzwj, boolean z) {
        return new zzbib(zzbgz, zzwj, z);
    }

    /* renamed from: d */
    public final int mo30260d() {
        return 16974374;
    }

    /* renamed from: a */
    public final WebResourceResponse mo30246a(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        WebResourceResponse webResourceResponse = new WebResourceResponse(str, str2, i, str3, map, inputStream);
        return webResourceResponse;
    }
}
