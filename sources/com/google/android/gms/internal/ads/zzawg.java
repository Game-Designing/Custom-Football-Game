package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

@zzard
public final class zzawg implements zzawi {
    /* renamed from: a */
    public final zzbbh<String> mo30150a(String str, PackageInfo packageInfo) {
        return zzbar.m26376a(str);
    }

    /* renamed from: a */
    public final zzbbh<Info> mo30149a(Context context) {
        zzbbr zzbbr = new zzbbr();
        zzyt.m31532a();
        if (zzazt.m26317c(context)) {
            zzaxg.m26094a((Runnable) new C9143Tb(this, context, zzbbr));
        }
        return zzbbr;
    }
}
