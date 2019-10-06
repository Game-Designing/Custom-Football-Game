package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.J */
final class C8928J implements zzaho<zzbgz> {
    C8928J() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbgz.zzlc();
            return;
        }
        if ("resume".equals(str)) {
            zzbgz.zzld();
        }
    }
}
