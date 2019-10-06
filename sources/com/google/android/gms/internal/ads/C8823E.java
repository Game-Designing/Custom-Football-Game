package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzd;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.E */
final class C8823E implements zzaho<zzbgz> {
    C8823E() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        zzd i = zzbgz.mo28758i();
        if (i != null) {
            i.close();
            return;
        }
        zzd l = zzbgz.mo28762l();
        if (l != null) {
            l.close();
        } else {
            zzbad.m26359d("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
