package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.K */
final class C8949K implements zzaho<zzbgz> {
    C8949K() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        if (map.keySet().contains("start")) {
            zzbgz.mo28714a().mo30614g();
        } else if (map.keySet().contains("stop")) {
            zzbgz.mo28714a().mo30615h();
        } else {
            if (map.keySet().contains("cancel")) {
                zzbgz.mo28714a().mo30592a();
            }
        }
    }
}
