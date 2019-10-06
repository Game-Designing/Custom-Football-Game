package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzcya {
    /* renamed from: a */
    public static void m28997a(Throwable th, String str) {
        int a = zzcgm.m28419a(th);
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(a);
        zzbad.m26357c(sb.toString());
        zzawz.m26002e(str, th);
        if (zzcgm.m28419a(th) != 3) {
            zzk.zzlk().mo30170b(th, str);
        }
    }

    /* renamed from: a */
    public static void m28996a(Context context, boolean z) {
        if (z) {
            zzbad.m26357c("This request is sent from a test device.");
            return;
        }
        zzyt.m31532a();
        String a = zzazt.m26304a(context);
        StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 71);
        sb.append("Use AdRequest.Builder.addTestDevice(\"");
        sb.append(a);
        sb.append("\") to get test ads on this device.");
        zzbad.m26357c(sb.toString());
    }
}
