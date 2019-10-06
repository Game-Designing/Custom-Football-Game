package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdet.zza;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.ads.in */
final class C9498in implements zzdka {

    /* renamed from: a */
    private final String f22563a;

    /* renamed from: b */
    private final int f22564b;

    /* renamed from: c */
    private zzdet f22565c;

    /* renamed from: d */
    private zzddr f22566d;

    /* renamed from: e */
    private int f22567e;

    C9498in(zzdgw zzdgw) throws GeneralSecurityException {
        this.f22563a = zzdgw.mo31470l();
        if (this.f22563a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzdev a = zzdev.m29301a(zzdgw.mo31471m());
                this.f22565c = (zzdet) zzdcf.m29193b(zzdgw);
                this.f22564b = a.mo31427l();
            } catch (zzdok e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.f22563a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzddt a2 = zzddt.m29229a(zzdgw.mo31471m());
                this.f22566d = (zzddr) zzdcf.m29193b(zzdgw);
                this.f22567e = a2.mo31401l().mo31411l();
                this.f22564b = this.f22567e + a2.mo31402m().mo31460l();
            } catch (zzdok e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String str = "unsupported AEAD DEM key type: ";
            String valueOf = String.valueOf(this.f22563a);
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    /* renamed from: a */
    public final int mo29006a() {
        return this.f22564b;
    }

    /* renamed from: a */
    public final zzdbj mo29007a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.f22564b) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.f22563a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            return (zzdbj) zzdcf.m29187a(this.f22563a, (zzdpk) (zzdet) ((zza) zzdet.m29294n().mo31534a(this.f22565c)).mo31426a(zzdmr.m29653a(bArr, 0, this.f22564b)).mo31612g(), zzdbj.class);
        } else if (this.f22563a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.f22567e);
            zzdgl zzdgl = (zzdgl) ((zzdgl.zza) zzdgl.m29402o().mo31534a(this.f22566d.mo31397n())).mo31459a(zzdmr.m29656b(Arrays.copyOfRange(bArr, this.f22567e, this.f22564b))).mo31612g();
            return (zzdbj) zzdcf.m29187a(this.f22563a, (zzdpk) (zzddr) zzddr.m29220o().mo31398a(this.f22566d.mo31395l()).mo31399a((zzdeb) ((zzdeb.zza) zzdeb.m29244o().mo31534a(this.f22566d.mo31396m())).mo31410a(zzdmr.m29656b(copyOfRange)).mo31612g()).mo31400a(zzdgl).mo31612g(), zzdbj.class);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
