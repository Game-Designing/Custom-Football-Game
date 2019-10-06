package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.km */
final /* synthetic */ class C9541km implements Callable {

    /* renamed from: a */
    static final Callable f22691a = new C9541km();

    private C9541km() {
    }

    public final Object call() {
        String[] split;
        HashMap hashMap = new HashMap();
        String str = (String) zzyt.m31536e().mo29599a(zzacu.f23998R);
        if (str != null && !str.isEmpty()) {
            if (VERSION.SDK_INT >= ((Integer) zzyt.m31536e().mo29599a(zzacu.f24004S)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzazr.m26292a(str2));
                }
            }
        }
        return new zzcxg(hashMap);
    }
}
