package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzk;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
@zzard
public class zzbia extends zzbha {
    public zzbia(zzbgz zzbgz, zzwj zzwj, boolean z) {
        super(zzbgz, zzwj, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final WebResourceResponse mo30642a(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbgz)) {
            zzbad.m26359d("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbgz zzbgz = (zzbgz) webView;
        zzavb zzavb = this.f25349v;
        if (zzavb != null) {
            zzavb.mo30106a(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.mo30591a(str, map);
        }
        if (zzbgz.mo28714a() != null) {
            zzbgz.mo28714a().mo30612e();
        }
        if (zzbgz.mo28766m().mo30650e()) {
            str2 = (String) zzyt.m31536e().mo29599a(zzacu.f24065ba);
        } else if (zzbgz.mo28791x()) {
            str2 = (String) zzyt.m31536e().mo29599a(zzacu.f24058aa);
        } else {
            str2 = (String) zzyt.m31536e().mo29599a(zzacu.f24046Z);
        }
        zzk.zzlg();
        return zzaxi.m26125c(zzbgz.getContext(), zzbgz.mo28793z().f25057a, str2);
    }
}
