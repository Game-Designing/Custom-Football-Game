package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.mh */
final class C9580mh implements zzaho<Object> {

    /* renamed from: a */
    private WeakReference<zzbxx> f22762a;

    private C9580mh(zzbxx zzbxx) {
        this.f22762a = new WeakReference<>(zzbxx);
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        zzbxx zzbxx = (zzbxx) this.f22762a.get();
        if (zzbxx != null) {
            zzbxx.f26029g.mo30877G();
        }
    }
}
