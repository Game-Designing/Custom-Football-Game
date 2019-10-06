package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.kh */
final class C9536kh implements zzaho<Object> {

    /* renamed from: a */
    private WeakReference<zzbxx> f22683a;

    private C9536kh(zzbxx zzbxx) {
        this.f22683a = new WeakReference<>(zzbxx);
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        zzbxx zzbxx = (zzbxx) this.f22683a.get();
        if (zzbxx != null) {
            if ("_ac".equals((String) map.get("eventName"))) {
                zzbxx.f26030h.onAdClicked();
            }
        }
    }
}
