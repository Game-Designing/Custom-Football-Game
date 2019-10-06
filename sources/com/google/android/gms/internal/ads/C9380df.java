package com.google.android.gms.internal.ads;

import android.net.Uri;

/* renamed from: com.google.android.gms.internal.ads.df */
final /* synthetic */ class C9380df implements zzbhw {

    /* renamed from: a */
    private final zzbgz f22177a;

    C9380df(zzbgz zzbgz) {
        this.f22177a = zzbgz;
    }

    /* renamed from: a */
    public final void mo28909a(Uri uri) {
        zzbii a = this.f22177a.mo28714a();
        if (a == null) {
            zzbad.m26355b("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            a.mo30595a(uri);
        }
    }
}
