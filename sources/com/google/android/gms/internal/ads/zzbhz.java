package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(11)
@zzard
public final class zzbhz extends zzbia {
    public zzbhz(zzbgz zzbgz, zzwj zzwj, boolean z) {
        super(zzbgz, zzwj, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return mo30642a(webView, str, null);
    }
}
