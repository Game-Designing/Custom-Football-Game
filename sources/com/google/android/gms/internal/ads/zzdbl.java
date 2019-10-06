package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgy.zza;
import java.security.GeneralSecurityException;

public final class zzdbl {
    /* renamed from: a */
    public static zzdgy m29134a(String str, String str2, String str3, int i, boolean z) {
        zza a = zzdgy.m29458q().mo31478a(str2);
        String valueOf = String.valueOf(str3);
        String str4 = "type.googleapis.com/google.crypto.tink.";
        return (zzdgy) a.mo31480b(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4)).mo31477a(0).mo31479a(true).mo31481c(str).mo31612g();
    }

    /* renamed from: a */
    public static void m29135a(zzdho zzdho) throws GeneralSecurityException {
        for (zzdgy zzdgy : zzdho.mo31512l()) {
            if (zzdgy.mo31472l().isEmpty()) {
                throw new GeneralSecurityException("Missing type_url.");
            } else if (zzdgy.mo31473m().isEmpty()) {
                throw new GeneralSecurityException("Missing primitive_name.");
            } else if (!zzdgy.mo31476p().isEmpty()) {
                zzdbk a = zzdcf.m29179a(zzdgy.mo31476p());
                zzdcf.m29191a(a.mo28589a());
                zzdcf.m29190a(a.mo28588a(zzdgy.mo31472l(), zzdgy.mo31473m(), zzdgy.mo31474n()), zzdgy.mo31475o());
            } else {
                throw new GeneralSecurityException("Missing catalogue_name.");
            }
        }
    }
}
