package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

public final class zzcci implements zzaho<Object> {

    /* renamed from: a */
    private final zzafo f26367a;

    /* renamed from: b */
    private final zzccj f26368b;

    /* renamed from: c */
    private final zzdte<zzccd> f26369c;

    public zzcci(zzbzc zzbzc, zzbyt zzbyt, zzccj zzccj, zzdte<zzccd> zzdte) {
        this.f26367a = zzbzc.mo31036b(zzbyt.mo31007e());
        this.f26368b = zzccj;
        this.f26369c = zzdte;
    }

    /* renamed from: a */
    public final void mo31109a() {
        if (this.f26367a != null) {
            this.f26368b.mo31114a("/nativeAdCustomClick", (zzaho<Object>) this);
        }
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map<String, String> map) {
        String str = (String) map.get("asset");
        try {
            this.f26367a.mo29699a((zzafe) this.f26369c.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzbad.m26358c(sb.toString(), e);
        }
    }
}
