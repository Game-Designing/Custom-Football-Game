package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzbit {
    /* renamed from: a */
    public static zzbgz m27063a(Context context, zzbin zzbin, String str, boolean z, boolean z2, zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) throws zzbhj {
        try {
            C9512jf jfVar = new C9512jf(context, zzbin, str, z, z2, zzdh, zzbai, null, zzj, zza, zzwj);
            return (zzbgz) zzazl.m26285a(jfVar);
        } catch (Throwable th) {
            zzk.zzlk().mo30168a(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbhj("Webview initialization failed.", th);
        }
    }
}
