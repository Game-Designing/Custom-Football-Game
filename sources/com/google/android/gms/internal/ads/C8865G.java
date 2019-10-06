package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.G */
final class C8865G implements zzaho<Object> {
    C8865G() {
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        String valueOf = String.valueOf((String) map.get("string"));
        String str = "Received log message: ";
        zzbad.m26357c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
