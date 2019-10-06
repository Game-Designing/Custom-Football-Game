package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdho.zza;
import java.security.GeneralSecurityException;

public final class zzdcj {
    @Deprecated

    /* renamed from: a */
    public static final zzdho f27786a;
    @Deprecated

    /* renamed from: b */
    private static final zzdho f27787b = ((zzdho) ((zza) zzdho.m29556m().mo31534a(f27786a)).mo31514a("TINK_AEAD_1_1_0").mo31612g());

    /* renamed from: c */
    public static final zzdho f27788c;

    /* renamed from: a */
    public static void m29194a() throws GeneralSecurityException {
        zzddo.m29209a();
        zzdcf.m29192a("TinkAead", (zzdbk<?>) new C9129Sm<Object>());
        zzdbl.m29135a(f27788c);
    }

    static {
        String str = "AesCtrHmacAeadKey";
        String str2 = "Aead";
        String str3 = "TinkAead";
        String str4 = "AesEaxKey";
        String str5 = "AesGcmKey";
        String str6 = "ChaCha20Poly1305Key";
        String str7 = "KmsAeadKey";
        String str8 = "KmsEnvelopeAeadKey";
        f27786a = (zzdho) ((zza) zzdho.m29556m().mo31534a(zzddo.f27819a)).mo31513a(zzdbl.m29134a(str3, str2, str, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str4, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str5, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str6, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str7, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str8, 0, true)).mo31514a("TINK_AEAD_1_0_0").mo31612g();
        f27788c = (zzdho) ((zza) zzdho.m29556m().mo31534a(zzddo.f27821c)).mo31513a(zzdbl.m29134a(str3, str2, str, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str4, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str5, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str6, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str7, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, str8, 0, true)).mo31513a(zzdbl.m29134a(str3, str2, "XChaCha20Poly1305Key", 0, true)).mo31514a("TINK_AEAD").mo31612g();
        try {
            m29194a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
