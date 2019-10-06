package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdha.zzb;
import java.security.GeneralSecurityException;

@Deprecated
public final class zzdbz {
    @Deprecated
    /* renamed from: a */
    public static final zzdbu m29167a(byte[] bArr) throws GeneralSecurityException {
        try {
            zzdha a = zzdha.m29478a(bArr);
            m29168a(a);
            return zzdbu.m29161a(a);
        } catch (zzdok e) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    /* renamed from: a */
    private static void m29168a(zzdha zzdha) throws GeneralSecurityException {
        for (zzb zzb : zzdha.mo31488m()) {
            if (zzb.mo31492n().mo31466n() == zzdgr.zzb.UNKNOWN_KEYMATERIAL || zzb.mo31492n().mo31466n() == zzdgr.zzb.SYMMETRIC) {
                throw new GeneralSecurityException("keyset contains secret key material");
            } else if (zzb.mo31492n().mo31466n() == zzdgr.zzb.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("keyset contains secret key material");
            }
        }
    }
}
