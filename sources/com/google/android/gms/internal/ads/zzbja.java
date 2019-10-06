package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;

@zzard
public final class zzbja {

    /* renamed from: a */
    public final String f25407a;

    /* renamed from: b */
    public final Uri f25408b;

    /* renamed from: c */
    private final String f25409c;

    /* renamed from: d */
    public final Map<String, String> f25410d;

    @TargetApi(21)
    public zzbja(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public zzbja(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private zzbja(String str, Uri uri, String str2, Map<String, String> map) {
        this.f25407a = str;
        this.f25408b = uri;
        if (str2 == null) {
            str2 = "GET";
        }
        this.f25409c = str2;
        if (map == null) {
            map = Collections.emptyMap();
        }
        this.f25410d = map;
    }
}
