package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdha.zzb;
import com.google.android.gms.internal.ads.zzdhc.zza;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.Rm */
final class C9108Rm {

    /* renamed from: a */
    private static final Charset f21669a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static zzdhc m22945a(zzdha zzdha) {
        zza a = zzdhc.m29495l().mo31495a(zzdha.mo31487l());
        for (zzb zzb : zzdha.mo31488m()) {
            a.mo31496a((zzdhc.zzb) zzdhc.zzb.m29508l().mo31500a(zzb.mo31492n().mo31464l()).mo31498a(zzb.mo31493o()).mo31499a(zzb.mo31490l()).mo31497a(zzb.mo31494p()).mo31612g());
        }
        return (zzdhc) a.mo31612g();
    }

    /* renamed from: b */
    public static void m22946b(zzdha zzdha) throws GeneralSecurityException {
        int l = zzdha.mo31487l();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzb zzb : zzdha.mo31488m()) {
            if (zzb.mo31493o() != zzdgu.DESTROYED) {
                i++;
                if (!zzb.mo31491m()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zzb.mo31494p())}));
                } else if (zzb.mo31490l() == zzdhm.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zzb.mo31494p())}));
                } else if (zzb.mo31493o() != zzdgu.UNKNOWN_STATUS) {
                    if (zzb.mo31493o() == zzdgu.ENABLED && zzb.mo31494p() == l) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (zzb.mo31492n().mo31466n() != zzdgr.zzb.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zzb.mo31494p())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("empty keyset");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
