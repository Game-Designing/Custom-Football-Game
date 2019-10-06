package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdho.zza;
import java.security.GeneralSecurityException;

public final class zzddc {
    @Deprecated

    /* renamed from: a */
    public static final zzdho f27814a;
    @Deprecated

    /* renamed from: b */
    public static final zzdho f27815b = ((zzdho) ((zza) zzdho.m29556m().mo31534a(f27814a)).mo31514a("TINK_HYBRID_1_1_0").mo31612g());

    /* renamed from: c */
    public static final zzdho f27816c;

    /* renamed from: a */
    public static void m29204a() throws GeneralSecurityException {
        zzdcj.m29194a();
        zzdcf.m29192a("TinkHybridEncrypt", (zzdbk<?>) new C9410en<Object>());
        zzdcf.m29192a("TinkHybridDecrypt", (zzdbk<?>) new C9388dn<Object>());
        zzdbl.m29135a(f27816c);
    }

    static {
        String str = "EciesAeadHkdfPrivateKey";
        String str2 = "HybridDecrypt";
        String str3 = "TinkHybridDecrypt";
        String str4 = "EciesAeadHkdfPublicKey";
        String str5 = "HybridEncrypt";
        String str6 = "TinkHybridEncrypt";
        f27814a = (zzdho) ((zza) zzdho.m29556m().mo31534a(zzdcj.f27786a)).mo31513a(zzdbl.m29134a(str3, str2, str, 0, true)).mo31513a(zzdbl.m29134a(str6, str5, str4, 0, true)).mo31514a("TINK_HYBRID_1_0_0").mo31612g();
        f27816c = (zzdho) ((zza) zzdho.m29556m().mo31534a(zzdcj.f27788c)).mo31513a(zzdbl.m29134a(str3, str2, str, 0, true)).mo31513a(zzdbl.m29134a(str6, str5, str4, 0, true)).mo31514a("TINK_HYBRID").mo31612g();
        try {
            m29204a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
