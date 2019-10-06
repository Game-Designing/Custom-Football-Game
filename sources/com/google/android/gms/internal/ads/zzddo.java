package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdho.zza;
import java.security.GeneralSecurityException;

public final class zzddo {
    @Deprecated

    /* renamed from: a */
    public static final zzdho f27819a = ((zzdho) zzdho.m29556m().mo31514a("TINK_MAC_1_0_0").mo31513a(zzdbl.m29134a("TinkMac", "Mac", "HmacKey", 0, true)).mo31612g());
    @Deprecated

    /* renamed from: b */
    private static final zzdho f27820b = ((zzdho) ((zza) zzdho.m29556m().mo31534a(f27819a)).mo31514a("TINK_MAC_1_1_0").mo31612g());

    /* renamed from: c */
    public static final zzdho f27821c = ((zzdho) ((zza) zzdho.m29556m().mo31534a(f27819a)).mo31514a("TINK_MAC").mo31612g());

    /* renamed from: a */
    public static void m29209a() throws GeneralSecurityException {
        zzdcf.m29192a("TinkMac", (zzdbk<?>) new C9564ln<Object>());
        zzdbl.m29135a(f27821c);
    }

    static {
        try {
            m29209a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
