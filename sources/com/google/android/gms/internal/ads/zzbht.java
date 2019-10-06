package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbih;

@TargetApi(17)
@zzard
public final class zzbht<WebViewT extends zzbhx & zzbif & zzbih> {

    /* renamed from: a */
    private final zzbhw f25370a;

    /* renamed from: b */
    private final WebViewT f25371b;

    /* renamed from: a */
    public static zzbht<zzbgz> m26964a(zzbgz zzbgz) {
        return new zzbht<>(zzbgz, new C9380df(zzbgz));
    }

    private zzbht(WebViewT webviewt, zzbhw zzbhw) {
        this.f25370a = zzbhw;
        this.f25371b = webviewt;
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzbad.m26359d("URL is empty, ignoring message");
        } else {
            zzaxi.f24961a.post(new C9402ef(this, str));
        }
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            zzawz.m26003f("Click string is empty, not proceeding.");
            return str2;
        }
        zzdh e = ((zzbif) this.f25371b).mo28748e();
        if (e == null) {
            zzawz.m26003f("Signal utils is empty, ignoring.");
            return str2;
        }
        zzdc a = e.mo31483a();
        if (a == null) {
            zzawz.m26003f("Signals object is empty, ignoring.");
            return str2;
        } else if (this.f25371b.getContext() != null) {
            return a.zza(this.f25371b.getContext(), str, ((zzbih) this.f25371b).getView(), this.f25371b.mo28780q());
        } else {
            zzawz.m26003f("Context is null, ignoring.");
            return str2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30634a(String str) {
        this.f25370a.mo28909a(Uri.parse(str));
    }
}
